package com.okgo.leetcode.recursion.backtracking.combination.q77;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shawn
 * @date 2020/12/13 13:15
 * @title Function
 */
/// Using bit mask
/// Time Complexity: O(2^n * n)
/// Space Complexity: O(1)
public class Solution3 {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();

        int LIMIT = (1 << n);
        for(int i = 0; i < LIMIT; i ++){
            List lst = getCombination(i);
            if(lst.size() == k) res.add(lst);
        }
        return res;
    }

    private List getCombination(int num){

        ArrayList<Integer> res = new ArrayList<>();
        int i = 1;
        while (num != 0){
            if(num % 2 == 1) res.add(i);
            i ++;
            num /= 2;
        }
        return res;
    }
}
