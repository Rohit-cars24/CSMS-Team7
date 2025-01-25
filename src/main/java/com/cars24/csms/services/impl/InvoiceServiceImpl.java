package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.impl.InvoiceDaoImpl;
import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.data.entities.CustomerEntity;
import com.cars24.csms.data.entities.InvoiceEntity;
import com.cars24.csms.data.repositories.AppointmentRepository;
import com.cars24.csms.data.repositories.CustomerRepository;
import com.cars24.csms.data.requests.CreateInvoiceRequest;
import com.cars24.csms.data.responses.ApiResponse;
import com.cars24.csms.exceptions.InvoiceServiceException;
import com.cars24.csms.services.InvoiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceDaoImpl invoiceDaoImpl;
    private final AppointmentRepository appointmentRepository;
    private final CustomerRepository customerRepository;
    @Override
    public ResponseEntity<ApiResponse> createInvoice(CreateInvoiceRequest createInvoiceRequest) {

        log.info("[InvoiceServiceImpl] createInvoice {}", createInvoiceRequest);

        ApiResponse apiResponse = new ApiResponse();

        boolean appIdExists = invoiceDaoImpl.checkAppointmentId(createInvoiceRequest.getAppId());
        if(!appIdExists){
            throw new InvoiceServiceException("Appointments id does not exist!");
        }
        else{
            apiResponse.setStatuscode(HttpStatus.OK.value());
            apiResponse.setSuccess(true);
            apiResponse.setMessage("Invoice record inserted successfully.");
            apiResponse.setService("INVSVC-" + HttpStatus.OK.value());
            apiResponse.setData(null);
            invoiceDaoImpl.createInvoiceResponse(createInvoiceRequest);
            return ResponseEntity.ok().body(apiResponse);
        }
    }

    public List<InvoiceEntity> fetchAppIdByCustomerId(int userId) {
        log.info("[InvoiceServiceImpl] fetchAppIdByCustomerId {}", userId);

        CustomerEntity customerEntity = customerRepository.findAllByUserid(userId);

        int customerId = customerEntity.getCustomer_id();

        List<AppointmentsEntity> appointmentsEntities = appointmentRepository.findAllByCustomerId(customerId);

        List<Integer> appIds = new ArrayList<>();

        for(AppointmentsEntity i : appointmentsEntities){
            appIds.add(i.getAppointmentId());
        }

        return invoiceDaoImpl.getAllInvoices(appIds);
    }

}
