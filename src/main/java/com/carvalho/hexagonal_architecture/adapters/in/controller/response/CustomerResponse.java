package com.carvalho.hexagonal_architecture.adapters.in.controller.response;

import com.carvalho.hexagonal_architecture.application.core.domain.Address;
import lombok.Data;

@Data
public class CustomerResponse {

    private String name;

    private Address address;

    private String cpf;

    private Boolean isValid;

}
