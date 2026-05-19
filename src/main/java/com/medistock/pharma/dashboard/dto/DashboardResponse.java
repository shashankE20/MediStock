package com.medistock.pharma.dashboard.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class DashboardResponse {

    private long totalMedicines;

    private int totalStockQuantity;

    private long lowStockCount;

    private long expiryAlertCount;

    private long totalSales;
}