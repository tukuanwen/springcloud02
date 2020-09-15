package com.tu.springboot005.dao;

import com.tu.springboot005.dao.mapper.EmployeeMapper;
import com.tu.springboot005.entity.Employee;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class EmployeeDao {
    @Autowired
    private EmployeeMapper employeeMapper;


    public Employee getOneEmployee(Integer id) {
        return employeeMapper.getOneEmployee(id);
    }

    public Employee getOneEmployee2(Integer id) {
        return employeeMapper.getOneEmployee2(id);
    }

    public int incrOneEmployee(Employee employee){

//        double h = 5/0;

        return employeeMapper.incrOneEmployee(employee);
    }
}
