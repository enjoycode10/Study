package com.okgo.principle.factory.absfactory.pizzastore.order;

import com.okgo.principle.factory.absfactory.pizzastore.pizza.Pizza;

// 抽象工厂模式的抽象层
public interface AbsFactory {
    // 让工厂子类具体实现
    public Pizza createPizza(String orderType);
}
