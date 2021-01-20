package com.okgo.algo.lb;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Shawn
 * @date 2021/1/8 21:19
 * @title Function
 * 整体代码思路和轮询法一致，先重建serverMap，再获取到server列表。
 * 在选取server的时候，通过Random的nextInt方法取0~keyList.size()区间的一个随机值，从而从服务器列表中随机获取到一台服务器地址进行返回。
 * 基于概率统计的理论，吞吐量越大，随机算法的效果越接近于轮询算法的效果。
 */
public class RandomServer {
    public static String getServer() {

        ArrayList<String> keyList = new ArrayList<>(IpMap.serverWeightMap.keySet());

        Random random = new Random();
        int randomPos = random.nextInt(keyList.size());//随机生成一个整数，这个整数的范围就是[0,keyList.size())

        return keyList.get(randomPos);
    }
}
