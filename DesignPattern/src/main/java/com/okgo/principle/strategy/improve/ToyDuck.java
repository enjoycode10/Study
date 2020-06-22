package com.okgo.principle.strategy.improve;

public class ToyDuck extends Duck {


    public ToyDuck() {
        // TODO Auto-generated constructor stub
        flyBehavior = new NoFlyBehavior();
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println("玩具鸭");
    }


    public void quack() {
        System.out.println("���Ѽ���ܽ�~~");
    }

    public void swim() {
        System.out.println("���Ѽ������Ӿ~~");
    }


}
