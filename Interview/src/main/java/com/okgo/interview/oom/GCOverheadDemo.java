package com.okgo.interview.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shawn
 * @date 2020/8/8 14:58
 * @title
 * JVM参数配置：
 *      -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 *      GC回收时间过长会抛出OOM。过长是指：超过98%的时间都用来做GC,并且回收不到2%的内存，连续多次GC都只回收不到2%的极端情况下会抛出这种错误。
 * 假设不抛出GC Overhead limit 错误会发生什么情况呢？
 *      GC清理的少量内存很快被再次填满，迫使GC再次执行，这样就形成恶性循环，CPU使用率一直都是100%，而GC没有任何成果。
 *
 * [Full GC (Ergonomics) [PSYoungGen: 2047K->2047K(2560K)] [ParOldGen: 7096K->7096K(7168K)] 9144K->9144K(9728K), [Metaspace: 3297K->3297K(1056768K)], 0.0478792 secs] [Times: user=0.08 sys=0.00, real=0.05 secs]
 * [Full GC (Ergonomics) [PSYoungGen: 2047K->0K(2560K)] [ParOldGen: 7117K->611K(7168K)] 9165K->611K(9728K), [Metaspace: 3327K->3327K(1056768K)], 0.0145574 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 * Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
 */
public class GCOverheadDemo {
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();

        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Exception e) {
            System.out.println("++++++++++++++++i: "+i);
            e.printStackTrace();
            throw e;
        }

    }
}
