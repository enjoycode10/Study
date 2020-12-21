package com.okgo.leetcode.test;

/**
 * @author Shawn
 * @date 2020/12/14 16:39
 * @title Function
 */
public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("synchronized block");
        }
    }
}

//通过 JDK 自带的 javap 命令查看 SynchronizedDemo 类的相关字节码信息：首先切换到类的对应目录执行  javac SynchronizedDemo.java 命令生成编译后的 .class 文件，
//然后执行 javap -c -s -v -l SynchronizedDemo.class

//{
//public com.okgo.leetcode.test.SynchronizedDemo();
//        descriptor: ()V
//        flags: ACC_PUBLIC
//        Code:
//        stack=1, locals=1, args_size=1
//        0: aload_0
//        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        4: return
//        LineNumberTable:
//        line 8: 0
//
//public void method();
//        descriptor: ()V
//        flags: ACC_PUBLIC
//        Code:
//        stack=2, locals=3, args_size=1
//        0: aload_0
//        1: dup
//        2: astore_1
//        3: monitorenter
//        4: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
//        7: ldc           #3                  // String synchronized block
//        9: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
//        12: aload_1
//        13: monitorexit
//        14: goto          22
//        17: astore_2
//        18: aload_1
//        19: monitorexit
//        20: aload_2
//        21: athrow
//        22: return
//        Exception table:
//        from    to  target type
//        4    14    17   any
//        17    20    17   any
//        LineNumberTable:
//        line 10: 0
//        line 11: 4
//        line 12: 12
//        line 13: 22
//        StackMapTable: number_of_entries = 2
//        frame_type = 255 /* full_frame */
//        offset_delta = 17
//        locals = [ class com/okgo/leetcode/test/SynchronizedDemo, class java/lang/Object ]
//        stack = [ class java/lang/Throwable ]
//        frame_type = 250 /* chop */
//        offset_delta = 4
//}

