package com.tu.springboot005;

import com.tu.springboot005.dao.mapper.EmployeeMapper;
import com.tu.springboot005.entity.Department;
import com.tu.springboot005.entity.Employee;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Springboot005ApplicationTests {


//    @Autowired
//    @Qualifier("myDbcp2DataSource")
//    private DataSource dataSource;
//
//    @Autowired
//    @Qualifier("C3P0DataSource")
//    private DataSource dataSource2;
//
//    @Autowired
//    @Qualifier("druidDataSource")
//    private DataSource dataSource3;

    private EmployeeMapper employeeMapper;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

//    @Test
//    public void springJdbcTemplateTest(){
//        try{
//            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//            String queryStr = "select * from tbl_employee";
//            List<Employee> resultList = new ArrayList<>();
//            jdbcTemplate.query(queryStr, (ResultSet resultSet)->{
//                Employee employee = new Employee();
//                employee.setId(resultSet.getInt("id"));
//                employee.setLastName(resultSet.getString("last_name"));
//                employee.setGender(resultSet.getString("gender"));
//                employee.setEmail(resultSet.getString("email"));
//                resultList.add(employee);
//            });
//            resultList.forEach((Employee employee) -> System.out.println(employee));
//        }catch (Exception exception){
//            exception.printStackTrace();
//        }
//    }
//
//    @Test
//    public void c3poDatasource(){
//        try{
//            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource2);
//            String queryStr = "select * from tbl_department";
//            List<Department> resultList = new ArrayList<>();
//            jdbcTemplate.query(queryStr, (ResultSet resultSet)->{
//                Department department = new Department();
//                department.setId(resultSet.getInt("id"));
//                department.setDeptName(resultSet.getString("dept_name"));
//                resultList.add(department);
//            });
//            resultList.forEach((Department department) -> System.out.println(department));
//        }catch (Exception exception){
//            exception.printStackTrace();
//        }
//    }
//
//    @Test
//    public void druidDatasource(){
//        try{
//            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource3);
//            String queryStr = "select * from tbl_department";
//            List<Department> resultList = new ArrayList<>();
//            jdbcTemplate.query(queryStr, (ResultSet resultSet)->{
//                Department department = new Department();
//                department.setId(resultSet.getInt("id"));
//                department.setDeptName(resultSet.getString("dept_name"));
//                resultList.add(department);
//            });
//            resultList.forEach((Department department) -> System.out.println(department));
//        }catch (Exception exception){
//            exception.printStackTrace();
//        }
//    }

    @Test
    public void doActiveMQ(){

        String queueName = "queue01";
        String message = "消息发送啦啦啦啦啦";
        jmsMessagingTemplate.convertAndSend(queueName, message);

        System.out.println("消息发送成功");
    }






}
