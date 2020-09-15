package com.tu.mybatisDemo.entity;

import java.io.Serializable;

public class Department implements Serializable {

    private Integer id;
    private String deptName;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", depameN='" + deptName + '\'' +

                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepameN() {
        return deptName;
    }

    public void setDepameN(String depameN) {
        this.deptName = depameN;
    }
}
