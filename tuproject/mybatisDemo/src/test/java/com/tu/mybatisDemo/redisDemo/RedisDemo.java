package com.tu.mybatisDemo.redisDemo;


import redis.clients.jedis.Jedis;

public class RedisDemo {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.36.128",6379);



        System.out.println(jedis.dbSize());


    }

}
