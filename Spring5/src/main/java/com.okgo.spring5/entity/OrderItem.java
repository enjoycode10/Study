package com.okgo.spring5.entity;

/**
 * @author Shawn
 * @date 2020/11/1 23:53
 * @title Function
 */
public class OrderItem {

    private String name;
    private Long quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}