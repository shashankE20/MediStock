package com.medistock.pharma.sales.controller;

import com.medistock.pharma.sales.dto.SellMedicineRequest;
import com.medistock.pharma.sales.dto.WeeklySalesReportResponse;
import com.medistock.pharma.sales.model.Sale;
import com.medistock.pharma.sales.service.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SalesController {

    private final SalesService salesService;

    @PostMapping("/sell/{medicineId}")
    public Sale sellMedicine(
            @PathVariable String medicineId,
            @RequestBody SellMedicineRequest request
    ) {

        return salesService.sellMedicine(
                medicineId,
                request
        );
    }
    @GetMapping("/weekly-report")
    public List<WeeklySalesReportResponse> getWeeklyHighSalesReport() {

        return salesService.getWeeklyHighSalesReport();
    }
}