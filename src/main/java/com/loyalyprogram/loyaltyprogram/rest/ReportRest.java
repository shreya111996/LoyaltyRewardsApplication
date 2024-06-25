package com.loyalyprogram.loyaltyprogram.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping(path = "/report")
public interface ReportRest {
    @GetMapping("/{userId}")
    public ResponseEntity<Map<String, Object>> getUserReport(@PathVariable int userId);
}
