/*
 *  Copyright (c) 1968 com.pengster,
 *  All Rights Reserved.
 *
 *
 * $Id$
 */

package com.pengster.sftp;

import java.util.List;

import net.sf.opensftp.SftpException;
import net.sf.opensftp.SftpFile;
import net.sf.opensftp.SftpResult;
import net.sf.opensftp.SftpSession;
import net.sf.opensftp.SftpUtil;
import net.sf.opensftp.SftpUtilFactory;


public class sftp
{
//    private AnonProfile anon;
//    private PasswordProfile pwd;
//    private sshProfile ssh;
//    
//    public void construct() {
//        
//        Site localhostSite = new Site("localhost", 22); // coreFTP
//        Site shotoKanSite = new Site("shotokan", 21); //FileZilla
//        Site rebexSite = new Site("test.rebex.net", 22); // rebex test server
//        Site ftpdSite = new Site("shotokan", 22); // freeFTPd on shotokan 
//        Site bitviseSite = new Site("shotokan", 22); // BitVise SSH Server on shotokan
//        
//        pwd = new PasswordProfile(localhostSite, "pengster", "pengster"); // coreFTP profile
//        //pwd = new PasswordProfile(rebexSite, "demo", "password"); // rebex profile
//        
//        //ssh = new sshProfile (localhostSite, "pengster", "f:\\pub\\hdml-sftp.rsa");
//        //ssh = new sshProfile (ftpdSite, "peng", "f:\\pub\\putty-ssh2.rsa");
//        ssh = new sshProfile (bitviseSite, "pengster", "f:\\pub\\hdml-sftp.rsa");
//    }
//    
//    
//    public static void main(String args[]) {
//        sftp app = new sftp();        
//        app.testProfiles();
//        //jschSftp app = new jschSftp();
//        //app.mash(args);
//    }
//    
//    
//    public void testProfiles() {
//        construct();
//        opensftp(ssh);
////        demo d = new demo();
////        d.doit(pwd);
//    }
//    public void jsch(Profile p) {
//    }
//    public void opensftp(Profile p) {
//        
//        SftpUtil util = SftpUtilFactory.getSftpUtil(); 
//        out("Connecting to "+p);
//        SftpSession session = connect(util, p); 
//        if (session != null)
//        {        
//            SftpResult result = util.ls(session);
//            if (result.getSuccessFlag()) {
//                List<SftpFile> files = (List<SftpFile>) result.getExtension();
//                out("Retrieved a listing %d files from %s", files.size(), p); 
//                for (SftpFile f : files) {
//                    out(f.getFullName());
//                }
//            }
//            else {
//                out("Failed to retrieve listing from "+p);
//            }
//            util.disconnect(session);
//        } else out("Failed to connect to "+p);   
//    }
//    
//    public SftpSession connect(SftpUtil util, Profile prof) {
//        try { 
//            SftpSession session = null;
//           switch (prof.getClass().getSimpleName()) {
//               case "AnonProfile":
//                   AnonProfile p = (AnonProfile)prof;
//                  session = util.connectByPasswdAuth(
//                                          p.getHost(),
//                                          p.getPort(),
//                                          p.getLogin(), 
//                                          "", 
//                                          SftpUtil.STRICT_HOST_KEY_CHECKING_OPTION_NO, 30000 );
//                  break;
//               case "PasswordProfile":
//                  PasswordProfile pp = (PasswordProfile)prof;
//                  session = util.connectByPasswdAuth(
//                                          pp.getHost(),
//                                          pp.getPort(),
//                                          pp.getLogin(), 
//                                          pp.getPassword(), 
//                                          SftpUtil.STRICT_HOST_KEY_CHECKING_OPTION_NO, 30000 );
//                  break;
//               case "sshProfile":
//                   sshProfile sp = (sshProfile)prof;
//                  session = util.connect( sp.getHost(),
//                                          sp.getLogin(), 
//                                          sp.getKeyfile(),
//                                          SftpUtil.STRICT_HOST_KEY_CHECKING_OPTION_YES);
//                  break;
//           }
//          out("Connected to "+prof);
//          return session;
//        } catch (SftpException e) { 
//          e.printStackTrace();
//          return null;
//        } catch (Exception e) {
//          e.printStackTrace();
//          return null;
//        }
//    }
//    
//    
//    public void out(String msg) {
//        System.out.println(msg);
//    }
//    public void out(String format, Object... args) {
//        out(String.format(format, args));
//    }
}
