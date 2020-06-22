package com.okgo.principle.strategy.improve;

public class WildDuck extends Duck {


    //构造器，传入 FlyBehavor 对象
    public WildDuck() {
        // TODO Auto-generated constructor stub
        flyBehavior = new GoodFlyBehavior();
    }


    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println(" 野鸭 ");
    }

}
