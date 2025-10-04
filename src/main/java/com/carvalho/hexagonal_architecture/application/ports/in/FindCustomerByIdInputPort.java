package com.carvalho.hexagonal_architecture.application.ports.in;

import com.carvalho.hexagonal_architecture.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer findById(String id);

}
