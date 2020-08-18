package com.okgo.interview.jmm;

/**
 * @author Shawn
 * @date 2020/7/4 10:44
 * @title Function
 */
class Code{
    public Code() {
        System.out.println("Code 的 构造方法 11111");
    }
    {
        System.out.println("Code 的 构造块 22222");
    }
    static{
        System.out.println("Code 的 静态代码块 33333");
    }
}

public class CodeBlock {
    public CodeBlock() {
        System.out.println("CodeBlock 的构造块 44444");
    }
    {
        System.out.println("CodeBlock 的 构造块 55555");
    }
    static{
        System.out.println("CodeBlock 的 静态代码块 66666");
    }

    public static void main(String[] args) {
        System.out.println("CodeBlock 的 main方法 77777");
        new Code();
        System.out.println("=============================");
        new Code();
        System.out.println("=============================");
        new CodeBlock();
    }
}
