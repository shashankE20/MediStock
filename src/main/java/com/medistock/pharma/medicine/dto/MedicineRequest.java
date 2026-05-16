package com.medistock.pharma.medicine.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MedicineRequest {

    private String medicineName;

    private Integer quantity;

    private Double price;

    private LocalDate expiryDate;

    private String manufacturer;
}