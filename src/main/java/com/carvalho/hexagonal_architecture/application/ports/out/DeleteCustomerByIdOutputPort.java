package com.carvalho.hexagonal_architecture.application.ports.out;

public interface DeleteCustomerByIdOutputPort {

    void delete(String id);
}
