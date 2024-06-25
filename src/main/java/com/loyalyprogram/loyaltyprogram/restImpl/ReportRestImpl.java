package com.loyalyprogram.loyaltyprogram.restImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.loyalyprogram.loyaltyprogram.rest.ReportRest;
import com.loyalyprogram.loyaltyprogram.service.ReportService;

import java.util.Map;

@RestController
public class ReportRestImpl implements ReportRest {

    @Autowired
    private ReportService reportService;

    @Override
    public ResponseEntity<Map<String, Object>> getUserReport(@PathVariable int userId) {
        Map<String, Object> reportData = reportService.getUserReport(userId);
        return ResponseEntity.ok(reportData);
    }
}
