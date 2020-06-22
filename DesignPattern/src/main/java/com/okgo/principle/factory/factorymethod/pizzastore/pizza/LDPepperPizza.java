package com.okgo.principle.factory.factorymethod.pizzastore.pizza;

public class LDPepperPizza extends Pizza {
    @Override
    public void prepare() {
        // TODO Auto-generated method stub
        setName("LDPepperPizza");
        System.out.println(" LDPepperPizza 准备材料");
    }
}
