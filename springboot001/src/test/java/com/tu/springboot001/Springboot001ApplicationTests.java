package com.tu.springboot001;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



import java.io.InputStream;

@SpringBootTest
class Springboot001ApplicationTests {

    @Test
    void contextLoads() {

        String resource = "org/mybatis/example/mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


    }

}
