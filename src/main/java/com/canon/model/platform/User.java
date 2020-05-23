package com.canon.model.platform;

/**
 * @Author Canon
 * @Date:Created in 0:16 2020/5/17
 * @Modify By: canon
 * @Despricction:
 * @since 1.0
 */
public class User {
    private Long id;
    private String userName;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
