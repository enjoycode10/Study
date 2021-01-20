package com.okgo.redis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Shawn
 * @date 2020/11/18 23:30
 * @title Function
 */
public class RedisUtils {

    private static JedisPool jedisPool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(10);

        jedisPool = new JedisPool(jedisPoolConfig,"ip",6379,100000);
    }

    public static Jedis getJedis() throws Exception{
        if (null!=jedisPool){
            return jedisPool.getResource();
        }
        throw new Exception("Jedispool is not ok");
    }
}
