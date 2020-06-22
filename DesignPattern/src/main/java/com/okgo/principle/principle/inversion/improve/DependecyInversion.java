package com.okgo.principle.principle.inversion.improve;

public class DependecyInversion {

    public static void main(String[] args) {
        //客户端无需改变
        Person person = new Person();
        person.receive(new Email());

        person.receive(new WeiXin());
    }

}

//定义接口
interface IReceiver {
    String getInfo();
}

class Email implements IReceiver {
    public String getInfo() {
        return "电子邮件信息: hello,world";
    }
}

//增加信息接收方式
class WeiXin implements IReceiver {
    public String getInfo() {
        return "微信信息: hello,ok";
    }
}

//方式2
class Person {
    //这里依赖接口
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}
