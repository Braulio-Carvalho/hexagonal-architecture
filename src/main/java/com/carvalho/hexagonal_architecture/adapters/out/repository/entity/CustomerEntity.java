package com.carvalho.hexagonal_architecture.adapters.out.repository.entity;

import com.carvalho.hexagonal_architecture.application.core.domain.Address;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "customers")
public class CustomerEntity {

    private String id;

    private String name;

    private Address address;

    private String cpf;

    private Boolean isValid;
}
