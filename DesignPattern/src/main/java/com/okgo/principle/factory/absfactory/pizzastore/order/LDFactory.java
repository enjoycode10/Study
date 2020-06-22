package com.okgo.principle.factory.absfactory.pizzastore.order;


import com.okgo.principle.factory.absfactory.pizzastore.pizza.LDCheesePizza;
import com.okgo.principle.factory.absfactory.pizzastore.pizza.LDPepperPizza;
import com.okgo.principle.factory.absfactory.pizzastore.pizza.Pizza;

public class LDFactory implements AbsFactory {

    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("LDFactory");
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        return pizza;
    }

}
