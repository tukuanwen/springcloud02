package com.tu.mybatisDemo.JDBCPage;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class JDBCCommon {


    public static void main(String[] args) {

        try {
            //1、加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //2、建立数据库连接
        String url = "jdbc:mysql://192.168.36.128:3306/mysqldemo";
        String userName = "root";
        String passWord = "123456";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, passWord);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //3、创建sql执行声明，拼装好sql语句
        /**
         * 1）Statement  执行静态sql语句
         * 2）PreparedStatement  执行动态sql语句
         * 3）CallableStatement  执行数据库存储过程
         */
        Statement statement = null; //执行静态sql语句
        PreparedStatement preparedStatement = null; //执行动态sql语句
        CallableStatement callableStatement = null; //执行存储过程
        try {
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement("");
            callableStatement = connection.prepareCall("");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //4、执行sql语句，并返回结果
        ResultSet resultSet = null;
        try {
            //================================执行静态sql语句===========================================
            resultSet = statement.executeQuery("");
            //或者
            statement.execute("");
            //================================执行动态sql语句=================================
            preparedStatement.executeQuery();
            //或者
            preparedStatement.execute();
            //================================执行存储过程=================================
            callableStatement.getArray("");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement != null || preparedStatement != null || callableStatement != null){
            try {
                statement.close();
                preparedStatement.close();
                callableStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(resultSet != null)
        {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }



}
