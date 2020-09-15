package com.tu.springboot005.controller;

import com.tu.springboot005.entity.Department;
import com.tu.springboot005.entity.Employee;
import com.tu.springboot005.service.EmployeeService;
import com.tu.springboot005.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TransactionService transactionService;

    @RequestMapping("/doHello")
    public String doHello(){

        return employeeService.doGetOneEmployee(1).toString();
    }

    @RequestMapping("/doEmployee")
    public String doSelectEmployee(){

        return employeeService.doGetOneEmployee2(4).toString();
    }

    @RequestMapping("doIncrData")
    public String doIncrEmployee(){

        Employee employee = new Employee();
        employee.setLastName("事务3");
        employee.setGender("0");
        employee.setEmail("emailuu");
        Department department = new Department();
        department.setDeptName("宁敏班3");

        employeeService.insertEmployeeAndDepartment(employee, department);

        return "成功2";
    }

    @RequestMapping("/doTransaction")
    public String doTransaction(){

        return transactionService.doTransactionByCoding();
    }

}
