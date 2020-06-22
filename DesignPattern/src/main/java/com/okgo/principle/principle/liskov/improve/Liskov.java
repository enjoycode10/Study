package com.okgo.principle.principle.liskov.improve;

public class Liskov {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        A a = new A();
        System.out.println("11-3=" + a.func1(11, 3));
        System.out.println("1-8=" + a.func1(1, 8));

        System.out.println("-----------------------");
        B b = new B();
        System.out.println("11+3=" + b.func1(11, 3));//���ﱾ�������11+3
        System.out.println("1+8=" + b.func1(1, 8));// 1+8
        System.out.println("11+3+9=" + b.func2(11, 3));
        //组合
        System.out.println("11-3=" + b.func3(11, 3));


    }

}

//����һ�����ӻ����Ļ���
class Base {
    //把更加基础或公共的方法和成员写到Base类
}

// A类
class A extends Base {
    // 返回两个数的差
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

// B类继承A
class B extends Base {
    //如果B要使用A的方法,使用组合的关系
    private A a = new A();

    public int func1(int a, int b) {
        return a + b;
    }

    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }

    //使用A的方法
    public int func3(int a, int b) {
        return this.a.func1(a, b);
    }
}
