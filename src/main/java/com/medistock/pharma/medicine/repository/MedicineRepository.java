package com.medistock.pharma.medicine.repository;

import com.medistock.pharma.medicine.model.Medicine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicineRepository extends MongoRepository<Medicine, String> {
}