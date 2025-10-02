package com.carvalho.hexagonal_architecture.application.core.domain;


public class Customer {

    public Customer(String id, String name, Address address, String cpf, Boolean isValid) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cpf = cpf;
        this.isValid = isValid;
    }

    public Customer() {
        this.isValid = false;
    }

    private String id;

    private String name;

    private Address address;

    private String cpf;

    private Boolean isValid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }
}
