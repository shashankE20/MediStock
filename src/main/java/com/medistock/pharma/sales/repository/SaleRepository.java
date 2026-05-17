package com.medistock.pharma.sales.repository;

import com.medistock.pharma.sales.model.Sale;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface SaleRepository extends MongoRepository<Sale, String> {
    List<Sale> findBySoldAtAfter(LocalDateTime  dateTime);
}