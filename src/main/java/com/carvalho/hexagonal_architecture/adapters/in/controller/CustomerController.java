package com.carvalho.hexagonal_architecture.adapters.in.controller;

import com.carvalho.hexagonal_architecture.adapters.in.controller.mapper.CustomerMapper;
import com.carvalho.hexagonal_architecture.adapters.in.controller.request.CustomerRequest;
import com.carvalho.hexagonal_architecture.adapters.in.controller.response.CustomerResponse;
import com.carvalho.hexagonal_architecture.application.ports.in.DeleteCustomerByIdInputPort;
import com.carvalho.hexagonal_architecture.application.ports.in.FindCustomerByIdInputPort;
import com.carvalho.hexagonal_architecture.application.ports.in.InsertCustomerInputPort;
import com.carvalho.hexagonal_architecture.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @Autowired
    CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id){
        var customer = findCustomerByIdInputPort.findById(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{/id}")
    public ResponseEntity<Void> deleteById(@PathVariable final String id){
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
