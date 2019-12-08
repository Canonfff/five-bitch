package com.canon.base.common;

/**
 * @program: five-bitch
 * @Auther: canon
 * @Date: 2019/12/6 14:35
 * @Description:应用用户上下文
 */
public class ServiceContext extends AbstractContext {

    public static final String USER_KEY = "$userVO$";

    public static void setUser(UserContext user) {
        put(USER_KEY, user);
    }

    public static UserContext getCurrentUser() {
        return (UserContext) get(USER_KEY);
    }
}
