package com.okgo.leetcode.test.q7;

/**
 * @author Shawn
 * @date 2020/12/1 23:22
 * @title Function
 * 7. 整数反转 -- 越界问题
 */
public class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int mod = x % 10;
            if (result>Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && mod > 7)) return 0;
            if (result<Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && mod < -8)) return 0;
            result = 10 * result + mod;
            x /= 10;
        }
        return result;
    }
}
