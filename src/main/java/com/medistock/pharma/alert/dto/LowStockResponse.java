package com.medistock.pharma.alert.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class LowStockResponse {

    private String medicineId;

    private String medicineName;

    private Integer quantity;

    private String alertMessage;
}