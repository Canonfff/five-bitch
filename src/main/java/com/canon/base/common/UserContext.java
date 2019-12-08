package com.canon.base.common;

import java.io.Serializable;

/**
 * @program: five-bitch
 * @Auther: canon
 * @Date: 2019/12/6 14:46
 * @Description:
 */
public class UserContext implements Serializable {
    private static final long serialVersionUID = -2913129138090304030L;

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
