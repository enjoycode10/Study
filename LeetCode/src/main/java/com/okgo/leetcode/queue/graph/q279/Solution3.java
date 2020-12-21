package com.okgo.leetcode.queue.graph.q279;

import java.util.Arrays;

/**
 * @author Shawn
 * @date 2020/12/11 20:26
 * @title Function
 */
/// Dynamic Programming
/// Time Complexity: O(n)
/// Space Complexity: O(n)
public class Solution3 {

    public int numSquares(int n) {

        int[] mem = new int[n+1];
        Arrays.fill(mem, Integer.MAX_VALUE);
        mem[0] = 0;
        for(int i = 1; i <= n ; i ++)
            for(int j = 1 ; i - j * j >= 0 ; j ++)
                mem[i] = Math.min(mem[i], 1 + mem[i - j * j]);

        return mem[n];
    }

    public static void main(String[] args) {

        System.out.println((new Solution3()).numSquares(12));
        System.out.println((new Solution3()).numSquares(13));
    }
}