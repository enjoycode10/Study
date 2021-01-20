package com.okgo.algo.lb;

import java.util.ArrayList;

/**
 * @author Shawn
 * @date 2021/1/8 21:50
 * @title Function
 * 前两部分和轮询法、随机法一样就不说了，差别在于路由选择部分。通过客户端的ip也就是remoteIp，取得它的Hash值，对服务器列表的大小取模，结果便是选用的服务器在服务器列表中的索引值。
 *
 * 源地址哈希法的优点在于：保证了相同客户端IP地址将会被哈希到同一台后端服务器，直到后端服务器列表变更。根据此特性可以在服务消费者与服务提供者之间建立有状态的session会话。
 *
 * 源地址哈希算法的缺点在于：除非集群中服务器的非常稳定，基本不会上下线，否则一旦有服务器上线、下线，那么通过源地址哈希算法路由到的服务器是服务器上线、下线前路由到的服务器的概率非常低，如果是session则取不到session，如果是缓存则可能引发"雪崩"。
 *
 */
public class HashRemoteIP {

    public static String getServer(){
        ArrayList<String> keyList = new ArrayList<>(IpMap.serverWeightMap.keySet());
        // 在Web应用中可通过HttpServlet的getRemoteIp方法获取
        String remoteIp = "127.0.0.1";
        return keyList.get( remoteIp.hashCode() % keyList.size());
    }

}
