/*
 *  Copyright (c) 1968 com.pengster,
 *  All Rights Reserved.
 *
 *
 * $Id$
 */

package com.pengster.sftp;

import java.util.HashMap;
import java.util.Map;

public class testSftp extends BaseTester
{
    private final String usage="testSftp <host:[port]> <login> <key-filepath>";

    public static void main(String[] args)
    {
        testSftp test = new testSftp();
        Profile p = test.processArgs(args);
        test.runTest(p);
    }   

    public Profile processArgs(String[] args) {
        if (args.length < 3)
            throw new IllegalArgumentException("Not enough arguments \n"+usage);
        Profile p = new Profile(args[0], args[1], args[2]);
        return p;
    }
    
    private Map<String, Boolean> testResults = new HashMap<String, Boolean>();
    public void runTest(Profile p) {
        out("Running Test against ["+p+"]");
        Boolean result;
        
        PingTester pingTest = new PingTester();
        out("\nPing test");
        result = pingTest.ping(p.getHost());
        testResults.put("Ping Test", result);
        out("Ping test...."+result);

        TelnetTester telnetTest = new TelnetTester();
        out("Telnet test....");
        result = telnetTest.telnet(p.getHost(), 23);
        testResults.put("Telnet Test", result);
        out("Telnet test...."+result);
        
        jschSftpTester jschTest = new jschSftpTester(); 
        out("SSH Auth test....");
        result = jschTest.auth(p);
        testResults.put("SSH Auth test", result);
        out("SSH Auth test...."+result);
        
        jcabiTester jcabiTest = new jcabiTester();
        out("Jcabi test....");
        result = jcabiTest.connect(p);
        testResults.put("Jcabi test", result);
        out("Jcabi test...."+result);
        
        AbstractSftpTester osftp =  new testOpenSftp();
        out("Connect test....");
        result = osftp.connect(p);
        testResults.put("Connect Test", result);
        out("Connect test...."+result);
        
        outputResults(testResults);
                
    }
    
    private void outputResults(Map<String, Boolean> results) {
        for(String key : results.keySet())
            out(" %s --> %s", key, (results.get(key) ? "SUCCESS" : "FAILED"));
    }

    
    
}
