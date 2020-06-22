package com.okgo.principle.factory.simplefactory.pizzastore.order;

import com.okgo.principle.factory.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class OrderPizza2 {

    Pizza pizza = null;
    String orderType = "";

    // ������
    public OrderPizza2() {

        do {
            orderType = getType();
            pizza = SimpleFactory.createPizza2(orderType);

            // 输出pizza
            if (pizza != null) { // 订购成功
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println(" 订购失败 ");
                break;
            }
        } while (true);
    }

    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza ����:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
