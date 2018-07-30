package com.wangchuncheng.dao;

import com.wangchuncheng.beans.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Wangchuncheng on 2018/7/24 10:07
 */
@Repository
public class EmployeeDao extends BaseDao {
    RowMapper rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
    public List<Employee> getAll() {
        String sql = "SELECT * FROM employee";
        List<Employee> all = jdbcTemplate.queryForList(sql, Employee.class);
        return all;
    }

    public Employee getOne(Integer id) {
        String sql = "SELECT * FROM location WHERE id= ? ";
        Employee one = (Employee) jdbcTemplate.queryForObject(sql, rowMapper, id);
        return one;
    }

    public List getList(Object entity) {
        Employee condition = (Employee) entity;
        String sql = "SELECT * FROM employee WHERE ";

        Boolean addHere = false;
        if (condition.getName() != null) {
            sql += "name='" + condition.getName()+"'";
            addHere = true;
        } else if (condition.getId() != null) {
            if (addHere) sql += " AND ";
            else addHere = true;
            sql += "id=" + condition.getId();
        } else if (condition.getEmail() != null) {
            if (addHere) sql += " AND ";
            else addHere = true;
            sql += "email='" + condition.getEmail()+"'";
        } else if (condition.getSalary() != null) {
            if (addHere) sql += " AND ";
            else addHere = true;
            sql += "salary=" + condition.getSalary();
        } else if (condition.getDepart_id() != null) {
            if (addHere) sql += " AND ";
            else addHere = true;
            sql += "depart_id=" + condition.getDepart_id();
        }
        List<Employee> employees = jdbcTemplate.query(sql, rowMapper);
        return employees;
    }

    public Employee getOneByName(String name) {
        String sql = "SELECT * FROM location WHERE name= ? ";
        RowMapper rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        Employee one = (Employee) jdbcTemplate.queryForObject(sql, rowMapper, name);
        return one;
    }
}
