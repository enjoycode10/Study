package com.okgo.leetcode.searchtable.q447;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shawn
 * @date 2020/12/10 22:33
 * @title Function
 * 447. 回旋镖的数量
 */
public class  Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> records = new HashMap<>(); //键：距离，值：频次
            for (int j = 0; j < points.length; j++) {
                int distance = dis(points[i], points[j]);
                if (j != i) records.put(distance, records.get(distance)+1);
            }

            //3. 通过Map.entrySet遍历key和value
            for(Map.Entry<Integer, Integer> entry : records.entrySet()){
                int value = entry.getValue();
                result += value * (value-1);
            }
        }
        return result;
    }

    //整形越界
    private int dis(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }


}
