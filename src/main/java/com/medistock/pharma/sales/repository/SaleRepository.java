package com.medistock.pharma.sales.repository;

import com.medistock.pharma.sales.model.Sale;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SaleRepository extends MongoRepository<Sale, String> {
}