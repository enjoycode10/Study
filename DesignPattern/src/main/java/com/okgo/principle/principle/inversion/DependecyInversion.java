package com.okgo.principle.principle.inversion;

public class DependecyInversion {

    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }

}


class Email {
    public String getInfo() {
        return "电子邮件信息: hello,world";
    }
}

//完成Person接收信息的功能
//方式1完成
//1. 简单易实现
//2. 若增加其他方式的信息，如微信，短信等，则需要新增类，且Person要添加相应的方法
//3. 解决思路：引入一个抽象的接口IReceiver，表示接收者，这样Person与接口IReceiver发生依赖
//   Email, WeiXin 等属于接收的范围，各自实现IReceiver就行, 这样就实现了依赖导致的原则
class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}
