package com.okgo.principle.singleton.type8;

public class SingletonTest08 {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance == instance2);

        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());

        instance.sayOK();
    }
}

// 枚举（推荐），不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
enum Singleton {
    INSTANCE; //

    public void sayOK() {
        System.out.println("ok~");
    }
}