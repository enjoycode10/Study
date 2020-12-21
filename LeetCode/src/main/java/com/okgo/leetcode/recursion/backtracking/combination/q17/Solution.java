package com.okgo.leetcode.recursion.backtracking.combination.q17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shawn
 * @date 2020/12/12 16:44
 * @title Function
 * 17. 电话号码的字母组合
 */
/// Backtracking
/// Time Complexity: O(2^len(s)) 约等 3^n
/// Space Complexity: O(len(s))
class Solution {

    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private List<String> res;

    public List<String> letterCombinations(String digits) {

        //3. 定义返回结果
        res = new ArrayList<>();
        if(digits.equals(""))
            return res;

        //1. 定义递归方法
        findCombination(digits, 0, "");
        return res;
    }

    /**
     *
     * @param digits 数字字符串
     * @param index 对应数字字符串中的索引
     * @param s s中保存了此时从digits[0...index-1]翻译得到的一个字母字符串，寻找和digits[index]匹配的字母，获得digits[0...index]翻译得到的解
     */
    private void findCombination(String digits, int index, String s){

        //2. 递归终止条件
        if(index == digits.length()){
            res.add(s);
            return;
        }

        //4. 递归过程
        Character c = digits.charAt(index);
        assert  c.compareTo('0') >= 0 && c.compareTo('9') <= 0 && c.compareTo('1') != 0;
        String letters = letterMap[c - '0'];
        for(int i = 0 ; i < letters.length() ; i ++)
            //5. 调用递归函数，更新参数
            findCombination(digits, index+1, s + letters.charAt(i));

    }

    private static void printList(List<String> list){
        for(String s: list)
            System.out.println(s);
    }

    public static void main(String[] args) {

        printList((new Solution()).letterCombinations("234"));
    }
}

