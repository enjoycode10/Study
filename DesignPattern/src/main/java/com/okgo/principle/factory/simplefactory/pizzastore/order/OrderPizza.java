package com.okgo.principle.factory.simplefactory.pizzastore.order;

import com.okgo.principle.factory.simplefactory.pizzastore.pizza.CheesePizza;
import com.okgo.principle.factory.simplefactory.pizzastore.pizza.GreekPizza;
import com.okgo.principle.factory.simplefactory.pizzastore.pizza.PepperPizza;
import com.okgo.principle.factory.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {

    // 构造器
	/*public OrderPizza() {
		Pizza pizza;
		String orderType; // 订购披萨类型
		do {
			orderType = getType();
			if (orderType.equals("greek")) {
				pizza = new GreekPizza();
				pizza.setName(" greek ");
			} else if (orderType.equals("cheese")) {
				pizza = new CheesePizza();
				pizza.setName(" cheese ");
			} else if (orderType.equals("pepper")) {
				pizza = new PepperPizza();
				pizza.setName(" pepper ");
			} else {
				break;
			}
			// 输出制作过程
			pizza.prepare();
			pizza.bake();
			pizza.cut();
			pizza.box();

		} while (true);
	}*/

    // 定义一个简单工厂对象
    SimpleFactory simpleFactory;
    Pizza pizza = null;

    public OrderPizza(SimpleFactory simpleFactory) {
        setFactory(simpleFactory);
    }

    public void setFactory(SimpleFactory simpleFactory) {
        String orderType = ""; // 披萨类型

        this.simpleFactory = simpleFactory; // 设置简单工厂对象

        do {
            orderType = getType();
            pizza = this.simpleFactory.createPizza(orderType);

            // 输出pizza
            if (pizza != null) { // 订购成功
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println(" 订购披萨失败 ");
                break;
            }
        } while (true);
    }

    // 获取用户希望订购披萨的种类
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
