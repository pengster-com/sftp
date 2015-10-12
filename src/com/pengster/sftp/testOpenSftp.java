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

public class testOpenSftp extends AbstractSftpTester
{

    public testOpenSftp()
    {
        // TODO Auto-generated constructor stub
    }

    private SftpUtil util = null; 
    private SftpSession session = null;
    
    public SftpUtil getUtil() {
        if (util == null)
            util = SftpUtilFactory.getSftpUtil();
        return util;
    }
    public boolean connect(Profile p) {
        try {
            out("Connecting to "+p);
            session = getUtil().connect( p.getHost(), p.getLogin(), p.getKeyfile(), 
                    SftpUtil.STRICT_HOST_KEY_CHECKING_OPTION_NO);
        } catch (SftpException ex) {
            out("OpenSftp:: failed to connect to "+p+" SftpException:"+ex.getMessage()); 
        }
        return (session != null);
    }
    
    public boolean list(Profile p) {
        
        SftpResult result = getUtil().ls(session);
        if (result.getSuccessFlag()) {
            List<SftpFile> files = (List<SftpFile>) result.getExtension();
            out("Retrieved a listing %d files from %s", files.size(), p); 
            for (SftpFile f : files) {
                out(f.getFullName());
            }
            return true;
        }
        else {
            out("Failed to retrieve listing from "+p);
            return false;
        }
    }

    public boolean disconnect(Profile p) {        
        if (session != null)
            util.disconnect(session);
        else 
            out("There is no session to disconnect from "+p);
        return true;
    }
    
    
}
