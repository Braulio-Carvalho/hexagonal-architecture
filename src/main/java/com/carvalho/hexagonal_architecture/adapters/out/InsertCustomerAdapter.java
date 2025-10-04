package com.carvalho.hexagonal_architecture.adapters.out;

import com.carvalho.hexagonal_architecture.adapters.out.repository.CustomerRepository;
import com.carvalho.hexagonal_architecture.adapters.out.repository.mapper.CustomerEntityMapper;
import com.carvalho.hexagonal_architecture.application.core.domain.Customer;
import com.carvalho.hexagonal_architecture.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
