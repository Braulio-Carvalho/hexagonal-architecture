package com.carvalho.hexagonal_architecture.adapters.out.client.mapper;

import com.carvalho.hexagonal_architecture.adapters.out.client.response.AddressResponse;
import com.carvalho.hexagonal_architecture.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

     Address toAddress(AddressResponse addressResponse);

}
