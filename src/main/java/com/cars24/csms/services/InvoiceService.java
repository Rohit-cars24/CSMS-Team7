package com.cars24.csms.services;

import com.cars24.csms.data.entities.InvoiceEntity;
import com.cars24.csms.data.requests.CreateInvoiceRequest;
import com.cars24.csms.data.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvoiceService {

    public ResponseEntity<ApiResponse> createInvoice(CreateInvoiceRequest createInvoiceRequest);
    public List<InvoiceEntity> fetchAppIdByCustomerId(int customerId);
}
