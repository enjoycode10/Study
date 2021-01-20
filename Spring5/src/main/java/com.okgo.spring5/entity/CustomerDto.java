package com.okgo.spring5.entity;

import java.util.List;

/**
 * @author Shawn
 * @date 2020/11/1 23:53
 * @title Function
 */
public class CustomerDto {

    public Long id;
    public String customerName;
    public List<OrderItemDto> orders;
}
