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

import org.apache.commons.net.telnet.TelnetClient;

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
            telnetClient.connect(host, port);
            telnetClient.disconnect();
            success = true;
        } catch (ConnectException ce) {
            out("Could not connect to server %s:%d", host, port);
        } catch (UnknownHostException e) {
            out("Unknown host: " + host);
        } catch (IOException e) {
            out("Error connecting to server: " + host + " - " + e.getMessage(), e);
        }
        return success;
    }
}
