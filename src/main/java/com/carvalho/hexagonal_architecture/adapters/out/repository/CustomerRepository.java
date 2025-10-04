package com.carvalho.hexagonal_architecture.adapters.out.repository;

import com.carvalho.hexagonal_architecture.adapters.out.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
