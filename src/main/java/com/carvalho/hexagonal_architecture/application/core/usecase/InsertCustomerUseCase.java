package com.carvalho.hexagonal_architecture.application.core.usecase;

import com.carvalho.hexagonal_architecture.application.core.domain.Customer;
import com.carvalho.hexagonal_architecture.application.ports.in.InsertCustomerInputPort;
import com.carvalho.hexagonal_architecture.application.ports.out.FindAddressByZipCodeOutputPort;
import com.carvalho.hexagonal_architecture.application.ports.out.InsertCustomerOutputPort;
import com.carvalho.hexagonal_architecture.application.ports.out.SendCpfValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfValidationOutputPort sendCpfValidationOutputPort;

    public InsertCustomerUseCase(
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            InsertCustomerOutputPort insertCustomerOutputPort, SendCpfValidationOutputPort sendCpfValidationOutputPort
    ) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfValidationOutputPort = sendCpfValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode){
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfValidationOutputPort.send(customer.getCpf());
    }

}
