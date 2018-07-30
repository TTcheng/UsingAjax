package com.wangchuncheng.dao;

import com.wangchuncheng.beans.Department;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Wangchuncheng on 2018/7/24 10:07
 */
@Repository
public class DepartmentDao extends BaseDao {
    RowMapper rowMapper = new BeanPropertyRowMapper<Department>(Department.class);

    public List<Department> getAll() {
        String sql = "SELECT * FROM department";
        List<Department> all = jdbcTemplate.queryForList(sql, Department.class);
        return all;
    }

    public Department getOne(Integer id) {
        String sql = "SELECT * FROM department WHERE id= ? ";
        Department one = (Department) jdbcTemplate.queryForObject(sql, rowMapper, id);
        return one;
    }

    public List getList(Object entity) {
        Department condition = (Department) entity;
        String sql = "SELECT * FROM department WHERE ";

        Boolean addHere = false;
        if (condition.getName() != null) {
            sql += "name = '" + condition.getName()+"'";
            addHere = true;
        } else if (condition.getId() != null) {
            if (addHere) sql += " AND ";
            else addHere = true;
            sql += "id = " + condition.getId();
        } else if (condition.getLoc_id() != null) {
            if (addHere) sql += " AND ";
            else addHere = true;
            sql += "loc_id = " + condition.getLoc_id();
        }
        List<Department> departments = jdbcTemplate.query(sql, rowMapper);
        return departments;
    }
}
