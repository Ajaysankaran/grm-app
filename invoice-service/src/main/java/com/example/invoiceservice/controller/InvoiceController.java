package com.example.invoiceservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1")
public class InvoiceController {

    @GetMapping("invoice")
    public String getInvoice() {
        return "Invoice are returned from invoice service";
    }
}
