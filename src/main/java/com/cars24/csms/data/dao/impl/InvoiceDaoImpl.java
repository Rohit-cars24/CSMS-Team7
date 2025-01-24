package com.cars24.csms.data.dao.impl;

import com.cars24.csms.data.dao.InvoiceDao;
import com.cars24.csms.data.entities.InvoiceEntity;
import com.cars24.csms.data.repositories.AppointmentRepository;
import com.cars24.csms.data.repositories.InvoiceRepository;
import com.cars24.csms.data.requests.CreateInvoiceRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service // marks the class as a service provider
@Slf4j
public class InvoiceDaoImpl implements InvoiceDao {

    private final InvoiceRepository invoiceRepository;

    private final AppointmentRepository appointmentRepository;
    @Override
    public int createInvoiceResponse(CreateInvoiceRequest createInvoiceRequest) {
        log.info("[InvoiceDaoImpl] createInvoiceResponse {}", createInvoiceRequest);
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setAppointmentId(createInvoiceRequest.getAppId());
        invoiceEntity.setAmount(createInvoiceRequest.getAmount());
        invoiceEntity.setPaymentStatus(createInvoiceRequest.getPaymentStatus().toString());
        invoiceRepository.save(invoiceEntity);
        return 0;
    }

    @Override
    public boolean checkAppointmentId(int appointmentId) {
        log.info("[InvoiceDaoImpl] checkAppointmentId {}", appointmentId);
        boolean result = invoiceRepository.existsById(appointmentId);
        return result;
    }

    @Override
    public List<InvoiceEntity> getAllInvoices(List<Integer> appointmentsId) {

        List<InvoiceEntity> invoices = new ArrayList<>();

        for(Integer id : appointmentsId){
            invoices.addAll(invoiceRepository.findAllByAppointmentId(id));
        }
        return invoices;
    }
}
