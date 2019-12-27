package com.canon.base.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

/**
 * @program: five-bitch
 * @Auther: canon
 * @Date: 2019/12/27 11:56
 * @Description:
 */
@Component
public class BaseMapper<T> {
    private final SqlSession sqlSession;
    public BaseMapper(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public T selectById(Object id) {
        return this.sqlSession.selectOne("selectByPrimaryKey", id);
    }
}
