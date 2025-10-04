package com.carvalho.hexagonal_architecture.application.core.usecase;

import com.carvalho.hexagonal_architecture.application.core.domain.Customer;
import com.carvalho.hexagonal_architecture.application.ports.in.FindCustomerByIdInputPort;
import com.carvalho.hexagonal_architecture.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort){
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    public Customer findById(String id){
    return findCustomerByIdOutputPort.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

}
