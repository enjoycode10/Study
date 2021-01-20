package com.okgo.spring5.mappers;

import com.okgo.spring5.entity.Customer;
import com.okgo.spring5.entity.CustomerDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author Shawn
 * @date 2020/11/1 23:56
 * @title Function
 */
@Mapper(uses = { OrderItemMapper.class })
public interface CustomerMapper {

    CustomerMapper MAPPER = Mappers.getMapper( CustomerMapper.class );

    @Mappings({
        @Mapping(source = "orders", target = "orderItems"),
        @Mapping(source = "customerName", target = "name")
    })
    Customer toCustomer(CustomerDto customerDto);

    @InheritInverseConfiguration
    CustomerDto fromCustomer(Customer customer);
}
