/*
 *  Copyright (c) 1968 com.pengster,
 *  All Rights Reserved.
 *
 *
 * $Id$
 */

package com.pengster.sftp;

import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import org.apache.commons.net.telnet.EchoOptionHandler;
import org.apache.commons.net.telnet.InvalidTelnetOptionException;
import org.apache.commons.net.telnet.SuppressGAOptionHandler;
import org.apache.commons.net.telnet.TelnetClient;
import org.apache.commons.net.telnet.TerminalTypeOptionHandler;

public class TelnetTester extends BaseTester
{

    public TelnetTester()
    {
        // TODO Auto-generated constructor stub
    }

    private static final int PORT_MIN = 0;
    private static final int PORT_MAX = 65535;
 
    public boolean telnet(String host, int port) 
    {
        boolean success = false;
        if (port < PORT_MIN || port > PORT_MAX) 
            throw new IllegalArgumentException(String.format("Invalid port [min=%d, max=%d]:%d",PORT_MIN, PORT_MAX, port) );
        
        final TelnetClient telnetClient = new TelnetClient();
        try {
            
            TerminalTypeOptionHandler ttopt = new TerminalTypeOptionHandler("VT100", false, false, true, false);
            EchoOptionHandler echoopt = new EchoOptionHandler(true, false, true, false);
            SuppressGAOptionHandler gaopt = new SuppressGAOptionHandler(true, true, true, true);
    
            telnetClient.addOptionHandler(ttopt);
            telnetClient.addOptionHandler(echoopt);
            telnetClient.addOptionHandler(gaopt);

            telnetClient.connect(host, port);
            out("Connected to Telnet server "+host);
            
            telnetClient.disconnect();
            success = true;
            
        } catch (InvalidTelnetOptionException e) {
            out("Error registering option handlers: " + e.getMessage());
        } catch (ConnectException ce) {
            out("Could not connect to server %s:%d", host, port);
        } catch (UnknownHostException e) {
            out("Unknown host: " + host);
        } catch (IOException e) {
            out("Error connecting or disconnecting from server: " + host + " - " + e.getMessage(), e);
        }
        return success;
    }
}
