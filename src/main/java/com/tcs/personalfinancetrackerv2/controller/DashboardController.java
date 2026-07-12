package com.tcs.personalfinancetrackerv2.controller;

import com.tcs.personalfinancetrackerv2.dto.DashboardResponse;
import com.tcs.personalfinancetrackerv2.service.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public DashboardResponse getDashboardSummary() {
        return dashboardService.getDashboardSummary();
    }
}