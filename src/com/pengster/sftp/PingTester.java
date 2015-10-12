/*
 *  Copyright (c) 1968 com.pengster,
 *  All Rights Reserved.
 *
 *
 * $Id$
 */

package com.pengster.sftp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PingTester extends BaseTester
{

    public PingTester()
    {
        // TODO Auto-generated constructor stub
    }
    
    public boolean ping(String host)   
    {
        boolean result = false;
        try {
            //String ipAddress = "127.0.0.1";
            InetAddress inet = InetAddress.getByName(host);
        
            out("Sending Ping Request to " + host);
            result = inet.isReachable(5000);
            out(result ? "Host is reachable" : "Host is NOT reachable");
        
        } catch (UnknownHostException uhx) {
            out("Ping Test failed::UnknownHostException:"+uhx.getMessage());
        } catch (IOException iox) {
            out("Ping Test failed::IOException:"+iox.getMessage());        
        }
        return result;
    }
}

    
    
    