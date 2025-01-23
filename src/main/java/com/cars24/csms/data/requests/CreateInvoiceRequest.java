package com.cars24.csms.data.requests;

import com.cars24.csms.data.enums.InvoiceStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Valid
@Data
public class CreateInvoiceRequest {

    @Valid
    @Min(value = 0, message = "Invalid appointment id.")
    @NotNull(message = "Appointment id cannot be empty")
    private int appId;

    @Valid
    @Min(value = 0, message = "Enter a valid amount.")
    @NotNull(message = "Amount cannot be empty")
    private double amount;

    @Valid
    @NotNull(message = "Payment status cannot be empty")
    private InvoiceStatus paymentStatus;

}
