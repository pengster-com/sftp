/*
 *  Copyright (c) 1968 com.pengster,
 *  All Rights Reserved.
 *
 *
 * $Id$
 */

package com.pengster.sftp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import com.jcabi.ssh.SSH;
import com.jcabi.ssh.Shell;

public class jcabiTester extends BaseTester
{

    public jcabiTester()
    {
        // TODO Auto-generated constructor stub
    }

    public boolean connect(Profile p) {
        try {
            String privateKey = loadKeyFile(p.getKeyfile());
            if (privateKey == null) throw new Exception("Failed to load key from "+p.getKeyfile());
            SSH ssh = new SSH(p.getHost(), 22, p.getLogin(), privateKey);
            if (ssh == null) throw new Exception("Failed to ssh connect to "+p.getHost());
            Shell.Safe safeShell = new Shell.Safe (ssh); 
            if (safeShell == null) throw new Exception("Failed to create Shell.Safe");
            Shell sshShell = new Shell.Verbose( safeShell );
            if (sshShell == null) throw new Exception("Failed to create Shell.Verbose");
            return true;
        } catch (Exception e) {
            out("Exception: "+e.getMessage());
        }
        return false;
    }
    
    
    private String loadKeyFile(String filename) {
        out("loading key from"+filename);
        try {
            File f = new File(filename);
            FileInputStream fis = new FileInputStream(f);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            StringBuffer sb = new StringBuffer();
            String line = null;
            int lineno = 1;
            while ((line = br.readLine()) != null && lineno < 10) {
                sb.append(line);
                lineno++;
            }         
            br.close();
            return sb.toString();
        } catch (FileNotFoundException fnf) {
            out("Cannot find "+filename);
        } catch (IOException iox) {
            out("sproblem reading "+filename);
        }
        return null;
    }
}
