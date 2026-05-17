package com.medistock.pharma.sales.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class WeeklySalesReportResponse {

    private String medicineName;

    private Integer totalQuantitySold;
}