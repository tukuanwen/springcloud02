package com.tu.mybatisDemo.mybatisDemo;

import com.tu.mybatisDemo.entity.Employee;
import com.tu.mybatisDemo.entity.Mapping.EmployeeMapping;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class MybatisDemo {

    private static Logger logger = Logger.getLogger(MybatisDemo.class.getName());

    String resource = "mybatis-config.xml";

    InputStream inputStream;

    {
        try {
            inputStream = Resources.getResourceAsStream(resource);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    public static void main(String[] args) {

//        getEmployee();
//        incrEmployee();
//        updEmployee();
//        delEmployee();
//        getEmployeeByCondition();
//        getListEmployeeByLastName();
//        getMapEmployeeByLastName();
        getMapEmployeeByLikeLastName();
    }

    private static void getMapEmployeeByLikeLastName(){

        String lastName = "T";
        MybatisDemo mybatisDemo = new MybatisDemo();
        SqlSession session = mybatisDemo.sqlSessionFactory.openSession();
        EmployeeMapping mapper = session.getMapper(EmployeeMapping.class);
        Map<String, Employee> mapEmployeeByLikeLastName = mapper.getMapEmployeeByLikeLastName(lastName);
        System.out.println(mapEmployeeByLikeLastName);
        session.close();

    }

    private static void getMapEmployeeByLastName(){

        String lastName = "tom";
        MybatisDemo mybatisDemo = new MybatisDemo();
        SqlSession session = mybatisDemo.sqlSessionFactory.openSession();
        EmployeeMapping mapper = session.getMapper(EmployeeMapping.class);
        Map<String, Object> mapEmployeeByLastName = mapper.getMapEmployeeByLastName(lastName);
        System.out.println(mapEmployeeByLastName.get("gender"));
        System.out.println(mapEmployeeByLastName.get("last_name"));
        System.out.println(mapEmployeeByLastName.get("email"));
        System.out.println(mapEmployeeByLastName.get("id"));
        session.close();

    }

    private static void getListEmployeeByLastName(){
        String lastName = "T";
        MybatisDemo mybatisDemo = new MybatisDemo();
        SqlSession session = mybatisDemo.sqlSessionFactory.openSession();
        EmployeeMapping mapper = session.getMapper(EmployeeMapping.class);
        List<Employee> listEmployeeByLastName = mapper.getListEmployeeByLastName(lastName);
        for (Employee employee : listEmployeeByLastName) {
            System.out.println(employee);
        }
        session.close();

    }

    private static void getEmployeeByCondition(){

        String lastName = "tom";
        String email = "tkw@163.com";
        String tbl = "tbl";
        MybatisDemo mybatisDemo = new MybatisDemo();
        SqlSession session = mybatisDemo.sqlSessionFactory.openSession();
        EmployeeMapping mapper = session.getMapper(EmployeeMapping.class);
        Employee employeeByCondition = mapper.getEmployeeByCondition(tbl, lastName, email);
        System.out.println(employeeByCondition);
        session.close();


    }

    private static void delEmployee(){

        Integer id = 3;
        MybatisDemo mybatisDemo = new MybatisDemo();
        SqlSession session = mybatisDemo.sqlSessionFactory.openSession();
        EmployeeMapping mapper = session.getMapper(EmployeeMapping.class);
        int i = mapper.decrEmployee(id);
        session.commit();
        session.close();
        System.out.println("删除条数:"+i);

    }


    private static void updEmployee(){

        Employee employee = new Employee();
        employee.setId(3);
        employee.setLastName("upd");
        employee.setGender("1");
        employee.setEmail("tkw@ee.com");

        MybatisDemo mybatisDemo = new MybatisDemo();
        SqlSession session = mybatisDemo.sqlSessionFactory.openSession();
        EmployeeMapping mapper = session.getMapper(EmployeeMapping.class);
        int i = mapper.updEmployee(employee);
        session.commit();
        session.close();
        System.out.println("修改条数:"+i);

    }

    /**
     * 增加employee
     */
    private static void incrEmployee(){

        Employee employee = new Employee();
        employee.setLastName("lisi");
        employee.setGender("0");
        employee.setEmail("tkw@aa.com");

        MybatisDemo mybatisDemo = new MybatisDemo();

        SqlSession session = mybatisDemo.sqlSessionFactory.openSession();

        EmployeeMapping mapper = session.getMapper(EmployeeMapping.class);
        int i = mapper.incrEmployee(employee);
        System.out.println("新增成功Id:"+employee.getId());
        System.out.println("插入成功条数："+i);
        session.commit();
        session.close();

    }

    /**
     * 查询Employee
     */
    private static void getEmployee() {
        MybatisDemo mybatisDemo = new MybatisDemo();
        SqlSession session = null;
        try{
            session = mybatisDemo.sqlSessionFactory.openSession();
            //方法一，直接读取xml配置文件中的调用方法
//            Employee employee = (Employee) session.selectOne("com.tu.mybatisDemo.entity.Employee.getEmployeeOne", 1);
//            logger.info(employee.toString());
//            System.out.println(employee);

            //方法二，通过接口映射xml的操作
            EmployeeMapping mapper = session.getMapper(EmployeeMapping.class);
            Employee employeeOne = mapper.getEmployeeOne(1);
            logger.info(employeeOne.toString());
            System.out.println(employeeOne);


        }finally {
            if(session != null) session.close();
        }
    }

}
