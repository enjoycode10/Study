package com.okgo.interview.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;


/**
 * @author Shawn
 * @date 2020/8/8 15:54
 * @title
 * JVM调参
 *      -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
 */
public class MetaspaceOOMDemo {
    static class OOMTest{}

    public static void main(String[] args) {
        int i = 0;
        try {
            while (true){
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(o,args));
                enhancer.create();
            }
        } catch (Exception e) {
            System.out.println("===========发生异常i: "+i);
            e.printStackTrace();
        }
    }
}
