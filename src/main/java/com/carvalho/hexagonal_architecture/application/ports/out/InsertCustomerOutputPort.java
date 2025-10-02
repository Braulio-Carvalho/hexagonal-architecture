package com.carvalho.hexagonal_architecture.application.ports.out;

import com.carvalho.hexagonal_architecture.application.core.domain.Customer;

public interface InsertCustomerOutputPort{

    void insert(Customer customer);
}
