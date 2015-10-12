/*
 *  Copyright (c) 1968 com.pengster,
 *  All Rights Reserved.
 *
 *
 * $Id$
 */

package com.pengster.sftp;

public class Site
{
    private String host;
    private int port;
    public Site(String host, int port)
    {
        super();
        this.host = host;
        this.port = port;
    }
    public String toString() {
        return String.format("%s:%d", getHost(), getPort() );
    }
    public String getHost()
    {
        return host;
    }
    public void setHost(String host)
    {
        this.host = host;
    }
    public int getPort()
    {
        return port;
    }
    public void setPort(int port)
    {
        this.port = port;
    }
    
    

}
