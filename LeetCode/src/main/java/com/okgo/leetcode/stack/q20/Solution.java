package com.okgo.leetcode.stack.q20;

import java.util.Stack;

/**
 * @author Shawn
 * @date 2020/12/11 16:39
 * @title Function
 */
public class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for( int i = 0 ; i < s.length() ; i ++ )
            if( s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else{

                if( stack.size() == 0 )
                    return false;

                Character c = stack.pop();

                Character match;
                if( s.charAt(i) == ')' )
                    match = '(';
                else if( s.charAt(i) == ']' )
                    match = '[';
                else{
                    assert s.charAt(i) == '}';
                    match = '{';
                }

                if(c != match)
                    return false;
            }

        if( stack.size() != 0 )
            return false;

        return true;
    }

    private static void printBool(boolean b){
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {

        printBool((new Solution()).isValid("()"));
        printBool((new Solution()).isValid("()[]{}"));
        printBool((new Solution()).isValid("(]"));
        printBool((new Solution()).isValid("([)]"));
    }
}
