package com.okgo.interview.oom;

/**
 * @author Shawn
 * @date 2020/8/8 14:42
 * @title Function
 */
public class StackOverFlowErrorDemo {
    public static void main(String[] args) {
        stackOverFlowError();
    }

    private static void stackOverFlowError() {
        stackOverFlowError(); // Exception in thread "main" java.lang.StackOverflowError
    }
}
