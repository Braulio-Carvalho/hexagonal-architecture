package com.carvalho.hexagonal_architecture.application.core.usecase;

import com.carvalho.hexagonal_architecture.application.ports.in.DeleteCustomerByIdInputPort;
import com.carvalho.hexagonal_architecture.application.ports.in.FindCustomerByIdInputPort;
import com.carvalho.hexagonal_architecture.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {


    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                     DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
    }

    @Override
    public void delete(String id){
        findCustomerByIdInputPort.findById(id);
        deleteCustomerByIdOutputPort.delete(id);
    }
}
