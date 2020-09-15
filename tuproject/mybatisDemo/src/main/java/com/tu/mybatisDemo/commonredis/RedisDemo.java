package com.tu.mybatisDemo.commonredis;

import redis.clients.jedis.Jedis;

public class RedisDemo {

    public static void main(String[] args) {


        Jedis jedis = new Jedis("192.168.36.128",6379);

        jedis.set("hash","Map");

        System.out.println(jedis.get("hash"));

    }


}
