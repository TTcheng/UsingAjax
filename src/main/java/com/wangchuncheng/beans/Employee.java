package com.wangchuncheng.beans;

/**
 * Created by Wangchuncheng on 2018/7/24 9:39
 */
public class Employee {
    private Integer id;
    private String email;
    private String name;
    private Double salary;
    private Integer depart_id;

    public Employee() {
    }

    public Employee(Integer id, String email, String name, Double salary) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getDepart_id() {
        return depart_id;
    }

    public void setDepart_id(Integer depart_id) {
        this.depart_id = depart_id;
    }
}
