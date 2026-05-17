package com.medistock.pharma.sales.service;

import com.medistock.pharma.medicine.model.Medicine;
import com.medistock.pharma.medicine.repository.MedicineRepository;
import com.medistock.pharma.sales.dto.SellMedicineRequest;
import com.medistock.pharma.sales.model.Sale;
import com.medistock.pharma.sales.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SalesService {

    private final MedicineRepository medicineRepository;
    private final SaleRepository saleRepository;

    public Sale sellMedicine(
            String medicineId,
            SellMedicineRequest request
    ) {

        Medicine medicine = medicineRepository.findById(medicineId)
                .orElseThrow(() ->
                        new RuntimeException("Medicine Not Found")
                );

        if (medicine.getQuantity() < request.getQuantitySold()) {

            throw new RuntimeException("Insufficient Stock");
        }

        medicine.setQuantity(
                medicine.getQuantity() - request.getQuantitySold()
        );

        medicineRepository.save(medicine);

        Sale sale = Sale.builder()
                .medicineId(medicine.getId())
                .medicineName(medicine.getMedicineName())
                .quantitySold(request.getQuantitySold())
                .totalPrice(
                        medicine.getPrice() * request.getQuantitySold()
                )
                .soldAt(LocalDateTime.now())
                .build();

        return saleRepository.save(sale);
    }
}