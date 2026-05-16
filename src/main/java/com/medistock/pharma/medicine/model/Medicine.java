package com.medistock.pharma.medicine.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "medicines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medicine {

    @Id
    private String id;

    private String medicineName;

    private Integer quantity;

    private Double price;

    private LocalDate expiryDate;

    private String manufacturer;
}