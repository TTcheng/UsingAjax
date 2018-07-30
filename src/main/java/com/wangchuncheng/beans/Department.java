package com.wangchuncheng.beans;

/**
 * Created by Wangchuncheng on 2018/7/24 9:39
 */
public class Department {
    private Integer id;
    private String name;
    private Integer loc_id;

    public Department() {
    }

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getLoc_id() {
        return loc_id;
    }

    public void setLoc_id(Integer loc_id) {
        this.loc_id = loc_id;
    }
}
