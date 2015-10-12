/*
 *  Copyright (c) 1968 com.pengster,
 *  All Rights Reserved.
 *
 *
 * $Id$
 */

package com.pengster.sftp;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class jschSftpTester extends AbstractSftpTester
{

    public jschSftpTester()
    {
        // TODO Auto-generated constructor stub
    }

    private Session     session     = null;
    private Channel     channel     = null;
    private ChannelSftp channelSftp = null;

    
    public boolean auth(Profile p) 
    {
        try{
                JSch jsch=new JSch();
                jsch.addIdentity(p.getKeyfile());
    
                session=jsch.getSession(p.getLogin(), p.getHost(), 22);
                
                java.util.Properties config = new java.util.Properties();
                config.put("StrictHostKeyChecking", "no");
                session.setConfig(config);
                session.connect();
                
                return true;
            }
            catch(JSchException e){
              out(e.getMessage());
            }
            catch(Exception e){
              out(e.getMessage());
            } 
        return false;
    }
    
    
    public boolean connect(Profile p) 
    {
        try {            
            if (session == null)
                auth(p);
                            
            channel = session.openChannel("sftp");
            channel.connect();
            out("Jsch Sftp channel connected....");
            channelSftp = (ChannelSftp)channel;
            return true;
            
        }
        catch(JSchException e) {
            out(e.getMessage());
        }
        catch(Exception e){
            out(e.getMessage());
        } 
        return false;
    }
    
    public boolean list(Profile p) {
        return true;
    }

    
    
}
