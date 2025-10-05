package com.carvalho.hexagonal_architecture.application.ports.out;

public interface SendCpfValidationOutputPort {

    void send(String cpf);
}
