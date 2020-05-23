package com.canon.service.dao;

import com.canon.model.platform.User;

import java.util.List;

/**
 * @Author Canon
 * @Date:Created in 0:17 2020/5/17
 * @Modify By: canon
 * @Despricction:
 * @since 1.0
 */
public interface UserDao {

    List<User> selectList(String userName);
}
