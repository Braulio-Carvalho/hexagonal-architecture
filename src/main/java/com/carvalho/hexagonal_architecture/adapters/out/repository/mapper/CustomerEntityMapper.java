package com.carvalho.hexagonal_architecture.adapters.out.repository.mapper;

import com.carvalho.hexagonal_architecture.adapters.out.repository.entity.CustomerEntity;
import com.carvalho.hexagonal_architecture.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);

}
