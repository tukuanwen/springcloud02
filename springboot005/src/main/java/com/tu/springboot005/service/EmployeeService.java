package com.tu.springboot005.service;

import com.tu.springboot005.dao.DepartmentDao;
import com.tu.springboot005.dao.EmployeeDao;
import com.tu.springboot005.entity.Department;
import com.tu.springboot005.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    public Employee doGetOneEmployee(Integer id){

        return employeeDao.getOneEmployee(id);
    }

    public Employee doGetOneEmployee2(Integer id){

        long start = System.currentTimeMillis();

        Employee employee = employeeDao.getOneEmployee2(id);
        long over = System.currentTimeMillis();

        System.out.println("时间差： " + (over - start) + " ms");
        return employee;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    public void insertEmployeeAndDepartment(Employee employee, Department department){


        Integer deptId = departmentDao.incrOneDepartment(department);
        department.setId(deptId);
        employee.setDept(department);
        Integer emplId = employeeDao.incrOneEmployee(employee);

        System.out.println("插入employee成功，ID为："+emplId);

    }

}
