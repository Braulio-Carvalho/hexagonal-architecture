package com.carvalho.hexagonal_architecture.adapters.out;

import com.carvalho.hexagonal_architecture.adapters.out.client.FindAddressByZipCodeClient;
import com.carvalho.hexagonal_architecture.adapters.out.client.mapper.AddressResponseMapper;
import com.carvalho.hexagonal_architecture.application.core.domain.Address;
import com.carvalho.hexagonal_architecture.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {


    @Autowired
    FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.address(zipCode);
        return addressResponseMapper.toAddress(addressResponse) ;
    }
}
