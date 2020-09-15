package com.tu.mybatisDemo.comLog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyApp {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        logger.trace("跟踪日志开始");
        Parent bar = new Parent();
        if (!bar.doIt()) {
            logger.error("错误日志");
        }
        logger.trace("跟踪日志结束");

    }


}
