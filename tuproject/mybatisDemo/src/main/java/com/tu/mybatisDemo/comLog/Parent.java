package com.tu.mybatisDemo.comLog;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Parent {

    static final Logger logger = LogManager.getLogger();

    public boolean doIt() {

        logger.error("错误日志");
        return false;
    }


}
