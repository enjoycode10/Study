package com.okgo.interview.jvm;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Shawn
 * @date 2020/7/4 7:12
 * @title Function
 */
public class SetMemoryDemo {
    // 查看自己机器上的默认堆内存和最大堆内存
    public static void main(String[] args) {
        /*System.out.println(Runtime.getRuntime().availableProcessors());
        //返回 Java虚拟机试图使用的最大内存量。物理内存的1/4（-Xmx）
        long maxMemory = Runtime.getRuntime().maxMemory();
        //返回 Java虚拟机中的内存总量(初始值)。物理内存的1/64（-Xms）
        long totalMemory = Runtime.getRuntime().totalMemory() ;
        System.out.println("-Xmx: MAX_MEMORY =" + maxMemory +"(字节)、" + (maxMemory / (double)1024 / 1024) + "MB");
        System.out.println("-Xms: DEFALUT_MEMORY = " + totalMemory + " (字节)、" + (totalMemory / (double)1024 / 1024) + "MB");*/

        byte[] bytes = new byte[40 * 1024 * 1024];
        /*String str = "test";
        while (true){
            str += str + new Random().nextInt(88888888) + new Random().nextInt(999999999);

            byte[] bytes = new byte[40 * 1024 * 1024];
        }*/

//        System.out.println("++++++++++hello GC+++++++++++");
//        try { TimeUnit.SECONDS.sleep(Integer.MAX_VALUE); } catch (InterruptedException e) { e.printStackTrace(); }

    }
}
