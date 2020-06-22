package com.okgo.principle.factory.factorymethod.pizzastore.pizza;

public class BJCheesePizza extends Pizza {

    @Override
    public void prepare() {
        // TODO Auto-generated method stub
        setName("BJCheesePizza");
        System.out.println(" BJCheesePizza 准备材料");
    }

}
