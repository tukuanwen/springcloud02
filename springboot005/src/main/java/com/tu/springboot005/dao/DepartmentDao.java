package com.tu.springboot005.dao;

import com.tu.springboot005.dao.mapper.DepartmentMapper;
import com.tu.springboot005.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao {

    @Autowired
    private DepartmentMapper departmentMapper;

    public int incrOneDepartment(Department department){



        return departmentMapper.incrDepartment(department);
    }

}
