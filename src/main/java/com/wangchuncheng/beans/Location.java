package com.wangchuncheng.beans;

import java.io.Serializable;

/**
 * Created by Wangchuncheng on 2018/7/24 9:38
 */
public class Location implements Serializable {
    private Integer id;
    private String city;

    public Location() {
    }

    public Location(Integer id, String city) {
        this.id = id;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
