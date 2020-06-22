package com.okgo.principle.factory.factorymethod.pizzastore.order;

import com.okgo.principle.factory.factorymethod.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public abstract class OrderPizza {

    // 定义抽象方法createPizza, 工厂子类具体实现
    abstract Pizza createPizza(String orderType);

    // ������
    public OrderPizza() {
        Pizza pizza = null;
        String orderType;
        do {
            orderType = getType();
            pizza = createPizza(orderType); // 抽象方法，由工厂子类完成
            // 输出制作过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();

        } while (true);
    }


    // 制作的pizza类型
    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
