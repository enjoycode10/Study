package com.okgo.leetcode.queue.graph.q279;

import javafx.util.Pair;

import java.util.LinkedList;

/**
 * @author Shawn
 * @date 2020/12/11 20:22
 * @title Function
 * 279. 完全平方数
 */
/// BFS
/// Time Complexity: O(n)
/// Space Complexity: O(n)
public class Solution1 {

    public int numSquares(int n) {

        if(n == 0)
            return 0;

        //Pair<第几个数字, 经过的路径数>
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(n, 0));

        boolean[] visited = new boolean[n+1];
        visited[n] = true;

        while(!queue.isEmpty()){
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();

            if(num == 0)
                return step;

            //向队列中推入了重复的节点
            for(int i = 1 ;  ; i ++){
                int a = num - i*i;
                if (a < 0) break;
                if(!visited[a]){
                    if(a == 0) return step + 1;
                    queue.addLast(new Pair(a, step + 1));
                    visited[a] = true;
                }
            }

            //for(int i = 1 ; num - i*i >= 0 ; i ++){
            //    int a = num - i*i;
            //    if(!visited[a]){
            //        if(a == 0) return step + 1;
            //        queue.addLast(new Pair(num - i * i, step + 1));
            //        visited[num - i * i] = true;
            //    }
            //}
        }

        throw new IllegalStateException("No Solution.");
    }

    public static void main(String[] args) {

        System.out.println((new Solution1()).numSquares(12));
        System.out.println((new Solution1()).numSquares(13));
    }
}
