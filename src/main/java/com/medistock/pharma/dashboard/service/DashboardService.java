package com.medistock.pharma.dashboard.service;

import com.medistock.pharma.dashboard.dto.DashboardResponse;
import com.medistock.pharma.medicine.model.Medicine;
import com.medistock.pharma.medicine.repository.MedicineRepository;
import com.medistock.pharma.sales.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit  ;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardService   {

    private final MedicineRepository medicineRepository;
    private final SaleRepository saleRepository;

    private static final int LOW_STOCK_THRESHOLD = 10;

    public DashboardResponse getDashboardSummary() {

        List<Medicine> medicines = medicineRepository.findAll();

        long totalMedicines = medicines.size();

        int totalStockQuantity = medicines.stream()
                .mapToInt(Medicine::getQuantity)
                .sum();

        long lowStockCount = medicines.stream()
                .filter(medicine ->
                        medicine.getQuantity() <= LOW_STOCK_THRESHOLD
                )
                .count();

        LocalDate today = LocalDate.now();

        long expiryAlertCount = medicines.stream()
                .filter(medicine -> {

                    long daysLeft = ChronoUnit.DAYS.between(
                            today,
                            medicine.getExpiryDate()
                    );

                    return daysLeft >= 0 && daysLeft <= 30;
                })
                .count();

        long totalSales = saleRepository.count();

        return DashboardResponse.builder()
                .totalMedicines(totalMedicines)
                .totalStockQuantity(totalStockQuantity)
                .lowStockCount(lowStockCount)
                .expiryAlertCount(expiryAlertCount)
                .totalSales(totalSales)
                .build();
    }
}
