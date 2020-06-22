package com.okgo.principle.singleton.type7;


public class SingletonTest07 {

    public static void main(String[] args) {
        System.out.println("使用静态内部类");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());

    }

}

/**
 * 静态内部类（推荐）
 * 静态内部类加载：外部类加载，静态内部类不加载；加载静态内部类时是线程安全的
 */
class Singleton {
    private static volatile Singleton instance;

    // 构造器私有化
    private Singleton() {
    }

    // 静态内部类，此类中有一个静态属性 Singleton
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    // 对外提供一个静态的共有方法，直接返回 SingletonInstance.INSTANCE
    public static synchronized Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}