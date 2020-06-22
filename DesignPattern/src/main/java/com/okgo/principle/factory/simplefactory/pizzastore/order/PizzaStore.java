package com.okgo.principle.factory.simplefactory.pizzastore.order;

//客户端，发出订购
public class PizzaStore {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//		new OrderPizza();

        // 使用简单工厂模式
        new OrderPizza(new SimpleFactory());
        System.out.println("~~退出程序~~");

//		new OrderPizza2();
    }

}
