package com.cars24.csms.data.responses;

import com.cars24.csms.data.enums.InvoiceStatus;
import jakarta.validation.Valid;
import lombok.Data;

@Valid
@Data
public class CreateInvoiceResponse {
    private int appId;
    private double amount;
    private InvoiceStatus paymentStatus;
}
