/*
 *  Copyright (c) 1968 com.pengster,
 *  All Rights Reserved.
 *
 *
 * $Id$
 */

package com.pengster.sftp;

public class Profile
{
    private String host;
    private int port;
    private String login;
    private String keyfile;
    
    public Profile(String hostport, String login, String keyfile)
    {
        super();
        int colon = hostport.indexOf(":");
        if (colon < 0) {
            this.host = hostport;
            this.port = -1;
        } else {
            String[] split = hostport.split(":");
            this.host = split[0];
            this.port = Integer.parseInt(split[1]);
        }
        this.login = login;
        this.keyfile = keyfile;
    }
    
    public String getHostport() {
        return String.format("%s:%d", getHost(), getPort());
    }
    
    public String toString() {
        return String.format("%s@%s %s", getLogin(), getHostport(), getKeyfile() );
    }

    public String getHost()
    {
        return host;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getKeyfile()
    {
        return keyfile;
    }

    public void setKeyfile(String keyfile)
    {
        this.keyfile = keyfile;
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
