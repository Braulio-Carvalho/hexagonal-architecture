package com.carvalho.hexagonal_architecture.adapters.in.consumer.mapper;


import com.carvalho.hexagonal_architecture.adapters.in.consumer.message.CustomerMessage;
import com.carvalho.hexagonal_architecture.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);

}
