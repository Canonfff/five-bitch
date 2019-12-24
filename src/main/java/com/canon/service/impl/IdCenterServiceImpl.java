package com.canon.service.impl;

import com.canon.model.platform.IdCenter;
import com.canon.service.IIdCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: five-bitch
 * @Auther: canon
 * @Date: 2019/12/9 16:26
 * @Description:
 */
@Service
public class IdCenterServiceImpl implements IIdCenterService {
//    @Autowired
//    IdCenterRepository idCenterRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<IdCenter> findAll() {

        return jdbcTemplate.query("select * from t_idcenter", new BeanPropertyRowMapper<IdCenter>(IdCenter.class));
    }
}
