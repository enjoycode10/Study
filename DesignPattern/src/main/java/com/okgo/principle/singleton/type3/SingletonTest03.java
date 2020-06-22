package com.okgo.principle.singleton.type3;


public class SingletonTest03 {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }

}

/**
 * 懒汉式（线程不安全）
 * 优点：起到lazy loading的效果，只能在单线程下使用
 * 缺点：多线程情况下不安全
 */
class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    // 对外提供一个共有的静态方法，当使用该方法时，才创建instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}