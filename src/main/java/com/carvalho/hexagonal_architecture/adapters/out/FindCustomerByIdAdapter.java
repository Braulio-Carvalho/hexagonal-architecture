package com.carvalho.hexagonal_architecture.adapters.out;

import com.carvalho.hexagonal_architecture.adapters.out.repository.CustomerRepository;
import com.carvalho.hexagonal_architecture.adapters.out.repository.mapper.CustomerEntityMapper;
import com.carvalho.hexagonal_architecture.application.core.domain.Customer;
import com.carvalho.hexagonal_architecture.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> findById(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }

}
