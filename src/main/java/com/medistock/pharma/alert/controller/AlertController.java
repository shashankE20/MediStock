package com.medistock.pharma.alert.controller;

import com.medistock.pharma.alert.dto.ExpiryAlertResponse;
import com.medistock.pharma.alert.dto.LowStockResponse;
import com.medistock.pharma.alert.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AlertController {

    private final AlertService alertService;

    @GetMapping("/low-stock")
    public List<LowStockResponse> getLowStockMedicines() {

        return alertService.getLowStockMedicines();
    }
    @GetMapping("/expiry")
    public List<ExpiryAlertResponse> getExpiryAlerts() {

        return alertService.getExpiryAlerts();
    }
}