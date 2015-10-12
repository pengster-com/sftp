/*
 *  Copyright (c) 1968 com.pengster,
 *  All Rights Reserved.
 *
 *
 * $Id$
 */

package com.pengster.sftp;


public abstract class AbstractSftpTester extends BaseTester
{

    public AbstractSftpTester()
    {
        // TODO Auto-generated constructor stub
    }
    public abstract boolean connect(Profile p);
    public abstract boolean list(Profile p);
    
    

}
