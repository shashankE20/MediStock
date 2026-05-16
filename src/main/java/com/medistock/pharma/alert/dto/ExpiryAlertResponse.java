package com.medistock.pharma.alert.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class ExpiryAlertResponse {

    private String medicineId;

    private String medicineName;

    private LocalDate expiryDate;

    private long daysLeft;

    private String alertMessage;
}