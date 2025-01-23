package com.cars24.csms.controllers;

import com.cars24.csms.data.entities.InvoiceEntity;
import com.cars24.csms.data.requests.CreateInvoiceRequest;
import com.cars24.csms.data.responses.ApiResponse;
import com.cars24.csms.data.responses.CreateInvoiceResponse;
import com.cars24.csms.services.impl.InvoiceServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("invoice")
@Validated
@Slf4j
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceServiceImpl invoiceService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createInvoice(@Valid @RequestBody CreateInvoiceRequest createInvoiceRequest){
        log.info("[InvoiceController] createInvoice {}", createInvoiceRequest);
        CreateInvoiceResponse createInvoiceResponse = new CreateInvoiceResponse();
        return invoiceService.createInvoice(createInvoiceRequest);
    }

    @GetMapping("/fetch")
    public ResponseEntity<List<InvoiceEntity>> fetchCustomerInvoices(@Valid @RequestParam int userId){
        log.info("[InvoiceController] fetchCustomerInvoices {}", userId);

        // assuming i get the customerId from the customer Repository
        // userId is stored as foreign key in customers table

        List<InvoiceEntity> invoices = invoiceService.fetchAppIdByCustomerId(userId);

        return ResponseEntity.ok().body(invoices);
    }
}
