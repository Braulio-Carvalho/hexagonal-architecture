package com.carvalho.hexagonal_architecture.application.core.usecase;

import com.carvalho.hexagonal_architecture.application.core.domain.Customer;
import com.carvalho.hexagonal_architecture.application.ports.in.FindCustomerByIdInputPort;
import com.carvalho.hexagonal_architecture.application.ports.in.UpdateCustomerInputPort;
import com.carvalho.hexagonal_architecture.application.ports.out.FindAddressByZipCodeOutputPort;
import com.carvalho.hexagonal_architecture.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;


    public UpdateCustomerUseCase(UpdateCustomerOutputPort updateCustomerOutputPort,
                                 FindCustomerByIdInputPort findCustomerByIdInputPort,
                                 FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort){
        this.updateCustomerOutputPort = updateCustomerOutputPort;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.findById(customer.getId());
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }
}
