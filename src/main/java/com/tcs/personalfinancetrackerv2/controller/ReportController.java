package com.tcs.personalfinancetrackerv2.controller;

import com.tcs.personalfinancetrackerv2.dto.ReportResponse;
import com.tcs.personalfinancetrackerv2.service.ReportService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/monthly")
    public ReportResponse getMonthlyReport() {
        return reportService.getMonthlyReport();
    }
}