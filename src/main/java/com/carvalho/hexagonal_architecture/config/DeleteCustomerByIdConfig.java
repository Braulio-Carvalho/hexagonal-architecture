package com.carvalho.hexagonal_architecture.config;

import com.carvalho.hexagonal_architecture.adapters.out.DeleteCustomerByIdAdapter;
import com.carvalho.hexagonal_architecture.application.core.usecase.DeleteCustomerByIdUseCase;
import com.carvalho.hexagonal_architecture.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    ){
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }
}
