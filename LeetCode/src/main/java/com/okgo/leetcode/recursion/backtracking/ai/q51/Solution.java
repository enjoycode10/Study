package com.okgo.leetcode.recursion.backtracking.ai.q51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Shawn
 * @date 2020/12/13 13:28
 * @title Function
 */
/// Basic Recursive
/// Time Complexity: O(n^n)
/// Space Complexity: O(n)
public class Solution {

    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;
    private ArrayList<List<String>> res;

    public List<List<String>> solveNQueens(int n) {

        //3. 定义返回结果
        res = new ArrayList<>();
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        //1. 递归函数入口
        LinkedList<Integer> row = new LinkedList<>();
        putQueen(n, 0, row);

        return res;
    }

    /**
     * 设置递归函数：尝试在一个n皇后问题中，摆放第index行的皇后位置
     * @param n n皇后
     * @param index 当前处理的行数
     * @param row row[i] = k 表示第i行的皇后放在第k列
     */
    private void putQueen(int n, int index, LinkedList<Integer> row){
        //2. 递归终止条件
        if(index == n){
            res.add(generateBoard(n, row)); //存储解
            return;
        }

        //4. 递归过程：尝试将第index行的皇后摆放在第i列
        for(int i = 0 ; i < n ; i ++)
            if(!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]){ //判断是否冲突
                row.addLast(i); //将第index行的皇后摆放在第i列
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;

                putQueen(n, index + 1, row); //摆放index+1个皇后
                //回溯过程，重置冲突条件后继续寻找下一个解
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                row.removeLast();
            }

        return;
    }

    private List<String> generateBoard(int n, LinkedList<Integer> row){

        assert row.size() == n;

        ArrayList<String> board = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++){
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[row.get(i)] = 'Q';
            board.add(new String(charArray));
        }
        return board;
    }

    private static void printBoard(List<String> board){
        for(String s: board)
            System.out.println(s);
        System.out.println();
    }

    public static void main(String[] args) {

        int n = 4;
        List<List<String>> res = new Solution().solveNQueens(n);
        for(List<String> board: res)
            printBoard(board);
    }
}
