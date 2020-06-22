package com.okgo.principle.factory.factorymethod.pizzastore.pizza;

public class BJPepperPizza extends Pizza {
    @Override
    public void prepare() {
        // TODO Auto-generated method stub
        setName("BJPepperPizza");
        System.out.println(" BJPepperPizza 准备材料");
    }
}
