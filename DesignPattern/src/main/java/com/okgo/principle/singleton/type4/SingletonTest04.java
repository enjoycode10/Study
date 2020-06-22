package com.okgo.principle.singleton.type4;


public class SingletonTest04 {

    public static void main(String[] args) {
        System.out.println("����ʽ2 �� �̰߳�ȫ~");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }

}

/**
 * 懒汉式（线程安全，同步的方式）
 * 优点：线程安全
 * 缺点：效率低，每个线程在想获得类的实例的时候，执行getInstance()方法都要进行同步。其实，这个方法只执行一次实例化代码就够了，后面想获得该类实例，直接return就行。
 */
class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    // 加入同步处理的代码，解决线程安全问题
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}