package com.okgo.principle.factory.absfactory.pizzastore.order;


import com.okgo.principle.factory.absfactory.pizzastore.pizza.BJCheesePizza;
import com.okgo.principle.factory.absfactory.pizzastore.pizza.BJPepperPizza;
import com.okgo.principle.factory.absfactory.pizzastore.pizza.Pizza;

//���ǹ�������
public class BJFactory implements AbsFactory {

    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("BJFactory");
        // TODO Auto-generated method stub
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }
        return pizza;
    }

}
