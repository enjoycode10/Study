package com.okgo.principle.singleton.type1;

public class SingletonTest01 {

    public static void main(String[] args) {
        // 测试
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }

}

/**
 * 饿汉式(静态变量)
 * 优点：写法简单，类加载的时候就完成了实例化，避免线程同步问题
 * 缺点：类加载的时候就完成了实例化，未达到 lazy loading 的效果。如果从始至终都未使用过这个实例，则会造成这个内存的浪费
 * <p>
 * ex: Jdk 中的 Runtime
 */
class Singleton {

    // 1. 构造器私有化，防止new
    private Singleton() {
    }

    // 2. 在本类内部创建对象实例
    private final static Singleton instance = new Singleton();

    // 3. 对外提供一个共有的静态方法，返回实例对象
    public static Singleton getInstance() {
        return instance;
    }

}