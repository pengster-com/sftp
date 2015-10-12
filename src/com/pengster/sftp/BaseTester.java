/*
 *  Copyright (c) 1968 com.pengster,
 *  All Rights Reserved.
 *
 *
 * $Id$
 */

package com.pengster.sftp;

import java.io.IOException;
import java.net.UnknownHostException;

public class BaseTester
{

    public BaseTester()
    {
        // TODO Auto-generated constructor stub
    }
    public void out(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }


}
