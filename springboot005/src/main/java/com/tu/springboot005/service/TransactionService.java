package com.tu.springboot005.service;

import com.tu.springboot005.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class TransactionService {

    @Autowired
    private PlatformTransactionManager transactionManager;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private EmployeeService employeeService;


    public String doTransactionByCoding(){
        System.out.println(transactionManager);
        transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(transactionManager);

       String result = transactionTemplate.execute((status)->{

           employeeService.doGetOneEmployee2(6);

       return "执行编程式事务成功";});

       return result;
    }


}
