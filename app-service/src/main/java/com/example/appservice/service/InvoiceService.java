package com.example.appservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "invoice", url = "http://localhost:9001/invoice-service/api/v1")
public interface InvoiceService {

    @GetMapping("invoice")
    String getInvoice();
}
