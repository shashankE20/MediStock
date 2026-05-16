package com.medistock.pharma.alert.service;

import com.medistock.pharma.alert.dto.ExpiryAlertResponse;
import com.medistock.pharma.alert.dto.LowStockResponse;
import com.medistock.pharma.medicine.model.Medicine;
import com.medistock.pharma.medicine.repository.MedicineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertService {

    private final MedicineRepository medicineRepository;

    private static final int LOW_STOCK_THRESHOLD = 10;

    public List<LowStockResponse> getLowStockMedicines() {

        List<Medicine> medicines = medicineRepository.findAll();

        return medicines.stream()
                .filter(medicine ->
                        medicine.getQuantity() <= LOW_STOCK_THRESHOLD
                )
                .map(medicine ->
                        LowStockResponse.builder()
                                .medicineId(medicine.getId())
                                .medicineName(medicine.getMedicineName())
                                .quantity(medicine.getQuantity())
                                .alertMessage(
                                        medicine.getMedicineName()
                                                + " stock is low"
                                )
                                .build()
                )
                .toList();
    }

    public List<ExpiryAlertResponse> getExpiryAlerts() {

        List<Medicine> medicines = medicineRepository.findAll();

        LocalDate today = LocalDate.now();

        return medicines.stream()
                .filter(medicine -> {

                    long daysLeft = ChronoUnit.DAYS.between(
                            today,
                            medicine.getExpiryDate()
                    );

                    return daysLeft >= 0 && daysLeft <= 30;
                })
                .map(medicine -> {

                    long daysLeft = ChronoUnit.DAYS.between(
                            today,
                            medicine.getExpiryDate()
                    );

                    return ExpiryAlertResponse.builder()
                            .medicineId(medicine.getId())
                            .medicineName(medicine.getMedicineName())
                            .expiryDate(medicine.getExpiryDate())
                            .daysLeft(daysLeft)
                            .alertMessage(
                                    medicine.getMedicineName()
                                            + " expires in "
                                            + daysLeft
                                            + " days"
                            )
                            .build();
                })
                .toList();
    }
}