package com.okgo.principle.factory.factorymethod.pizzastore.pizza;

public class LDCheesePizza extends Pizza {

    @Override
    public void prepare() {
        // TODO Auto-generated method stub
        setName("LDCheesePizza");
        System.out.println(" LDCheesePizza 准备材料 ");
    }
}
