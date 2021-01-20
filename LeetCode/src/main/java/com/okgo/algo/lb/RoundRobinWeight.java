package com.okgo.algo.lb;

import java.util.*;

/**
 * @author Shawn
 * @date 2021/1/9 10:58
 * @title Function
 *
 * 加权轮询（Weight Round Robin）法
 *
 * 不同的服务器可能机器配置和当前系统的负载并不相同，因此它们的抗压能力也不尽相同，
 * 给配置高、负载低的机器配置更高的权重，让其处理更多的请求，而低配置、高负载的机器，则给其分配较低的权重，降低其系统负载。加
 * 权轮询法可以很好地处理这一问题，并将请求顺序按照权重分配到后端。
 *
 * 与轮询法类似，只是在获取服务器地址之前增加了一段权重计算的代码，根据权重的大小，将地址重复地增加到服务器地址列表中，权重越大，该服务器每轮所获得的请求数量越多。
 */
public class RoundRobinWeight {
    private static Integer pos = 0;

    public static String getServer(){
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<>(IpMap.serverWeightMap);
        Set<String> keySet = serverMap.keySet();
        Iterator<String> iterator = keySet.iterator();
        ArrayList<String> serverList = new ArrayList<>();
        while (iterator.hasNext()){
            String server = iterator.next();
            int weight = serverMap.get(server);
            for (int i = 0; i < weight; i++)
                    serverList.add(server);
        }

        String server;
        synchronized (pos){
            if (pos >= serverList.size()) pos = 0;
            server = serverList.get(pos);
        }
        return server;
    }
}
