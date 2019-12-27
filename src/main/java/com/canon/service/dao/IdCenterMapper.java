package com.canon.service.dao;

import com.canon.model.platform.IdCenter;

import java.util.List;

/**
 * @program: five-bitch
 * @Auther: canon
 * @Date: 2019/12/24 17:06
 * @Description:
 */

public interface IdCenterMapper {

    List<IdCenter> findAll(Long id);

    IdCenter selectByPrimaryKey(Long id);
}
