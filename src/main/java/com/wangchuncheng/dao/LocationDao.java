package com.wangchuncheng.dao;


import com.wangchuncheng.beans.Location;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Wangchuncheng on 2018/7/24 9:43
 */
@Repository
public class LocationDao extends BaseDao {
    RowMapper<Location> rowMapper = new BeanPropertyRowMapper<Location>(Location.class);

    public List<Location> getAll() {
        String sql = "SELECT * FROM location";
        List<Location> locations = jdbcTemplate.query(sql, rowMapper);
        return locations;
    }

    public Location getOne(Integer id) {
        String sql = "SELECT * FROM location WHERE id= ? ";
        Location location = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return location;
    }

    @Override
    public List<Location> getList(Object entity) {
        Location condition = (Location) entity;
        String sql = "SELECT * FROM location WHERE ";

        Boolean addHere = false;
        if (condition.getCity() != null) {
            sql += "city='" + condition.getCity() + "'";
            addHere = true;
        } else if (condition.getId() != null) {
            if (addHere) sql += " AND ";
            else addHere = true;
            sql += "id=" + condition.getId();
        }
        List<Location> locations = jdbcTemplate.query(sql, rowMapper);
        return locations;
    }
}
