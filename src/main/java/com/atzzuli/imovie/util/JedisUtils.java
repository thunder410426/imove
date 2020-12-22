package com.atzzuli.imovie.util;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class JedisUtils {
        private static JedisPool jp = null;
        private static String host = null;
        private static int port;
        private static int maxTotal;
        private static int maxIdle;
        static {
            ResourceBundle rb = ResourceBundle.getBundle("redis");
            String host = rb.getString("redis.port");
            host = rb.getString("redis.port");
            port = Integer.parseInt(rb.getString("redis.port"));
            maxTotal = Integer.parseInt(rb.getString("redis.maxTotal"));
            maxIdle = Integer.parseInt(rb.getString("redis.maxIdle"));
            JedisPoolConfig jpc = new JedisPoolConfig();
            jpc.setMaxTotal(maxTotal);
            jpc.setMaxIdle(maxIdle);
            JedisPool jp = new JedisPool(jpc,host,port);
        }
        public static Jedis getJedis(){
            return jp.getResource();
        }

        public static void main(String[] args) {
            JedisUtils.getJedis();
        }
    }

