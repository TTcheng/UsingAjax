package com.wangchuncheng.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Wangchuncheng on 2018/7/24 10:46
 */
@Repository
public abstract class BaseDao {
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public abstract List getAll();
    public abstract Object getOne(Integer id);
    public abstract List getList(Object entity);

}
