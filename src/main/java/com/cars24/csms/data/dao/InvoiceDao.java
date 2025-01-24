package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.InvoiceEntity;
import com.cars24.csms.data.requests.CreateInvoiceRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvoiceDao {

    public int createInvoiceResponse(CreateInvoiceRequest createInvoiceRequest);

    public boolean checkAppointmentId(int appointmentId);

    public List<InvoiceEntity> getAllInvoices(List<Integer> appointmentsId);

}
