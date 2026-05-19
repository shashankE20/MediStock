package com.medistock.pharma.dashboard.controller;

import com.medistock.pharma.dashboard.dto.DashboardResponse;
import com.medistock.pharma.dashboard.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
@CrossOrigin("*")
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/summary")
    public DashboardResponse getDashboardSummary() {

        return dashboardService.getDashboardSummary();
    }
}