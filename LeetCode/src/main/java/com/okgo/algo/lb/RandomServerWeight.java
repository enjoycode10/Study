package com.okgo.algo.lb;

import java.util.*;

/**
 * @author Shawn
 * @date 2021/1/9 11:11
 * @title Function
 *
 * 与加权轮询法类似，加权随机法也是根据后端服务器不同的配置和负载情况来配置不同的权重。不同的是，它是按照权重来随机选择服务器的，而不是顺序。加权随机法的代码实现如下：
 */
public class RandomServerWeight {
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

        Random random = new Random();
        int randomPos = random.nextInt(serverList.size());//随机生成一个整数，这个整数的范围就是[0,keyList.size())
        return serverList.get(randomPos);
    }
}
