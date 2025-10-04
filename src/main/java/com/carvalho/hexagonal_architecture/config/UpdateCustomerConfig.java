package com.carvalho.hexagonal_architecture.config;

import com.carvalho.hexagonal_architecture.adapters.out.FindAddressByZipCodeAdapter;
import com.carvalho.hexagonal_architecture.adapters.out.UpdateCustomerAdapter;
import com.carvalho.hexagonal_architecture.application.core.usecase.FindCustomerByIdUseCase;
import com.carvalho.hexagonal_architecture.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            UpdateCustomerAdapter updateCustomerAdapter,
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter
    ){
        return new UpdateCustomerUseCase(updateCustomerAdapter, findCustomerByIdUseCase, findAddressByZipCodeAdapter);
    }
}

