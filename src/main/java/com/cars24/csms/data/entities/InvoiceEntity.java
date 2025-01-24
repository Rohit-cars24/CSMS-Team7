package com.cars24.csms.data.entities;


import jakarta.persistence.*;
import lombok.Data;


@Table(name = "invoices")
@Entity
@Data
public class InvoiceEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceId;

    @Column(name = "appointmentId", nullable = false)
    private int appointmentId;

    @Column(name = "amount")
    private double amount;

    @Column(name = "payment_status")
    private String paymentStatus;

}
