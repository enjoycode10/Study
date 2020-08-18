package com.okgo.interview.jvm;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * @author Shawn
 * @date 2020/7/5 0:38
 * @title 在Java中，可以作为GC Roots的对象有：
 *      1. 虚拟机栈（栈帧中的本地变量表）中引用的对象    如：demo1 引用 new GCRootDemo()
 *      2. 方法区中的类静态属性引用的对象  如：demo2 引用 new GCRootDemo()
 *      3. 方法区中常量引用的对象  如：demo3 引用 new GCRootDemo()
 *      4. 本地方法栈JNI（Native方法）中引用的对象
 *
 *
 */
public class GCRootDemo {
    private byte[] bytes = new byte[100*1024*1024];
    private static GCRootDemo demo2 = new GCRootDemo();
    private static final GCRootDemo demo3 = new GCRootDemo();

    public static void main(String[] args) {
        m1();
    }

    private static void m1() {
        GCRootDemo demo1 = new GCRootDemo();
        System.gc();
        System.out.println("第一次GC完成");
    }
}
