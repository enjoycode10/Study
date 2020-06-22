package com.okgo.principle.factory.simplefactory.pizzastore.pizza;

// 将 Pizza 类做成抽象
public abstract class Pizza {
    protected String name; //名字

    // 准备原材料，不同披萨原材料不同，因此做成抽象方法
    public abstract void prepare();


    public void bake() {
        System.out.println(name + " baking;");
    }

    public void cut() {
        System.out.println(name + " cutting;");
    }

    public void box() {
        System.out.println(name + " boxing;");
    }

    public void setName(String name) {
        this.name = name;
    }
}
