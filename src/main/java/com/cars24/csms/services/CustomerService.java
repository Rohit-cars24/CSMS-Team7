package com.cars24.csms.services;

import com.cars24.csms.data.entities.CustomerEntity;
import com.cars24.csms.data.requests.CreateCustomerRequest;
import com.cars24.csms.data.requests.DeleteCustomerRequest;
import com.cars24.csms.data.requests.GetCustomerRequest;
import com.cars24.csms.data.requests.UpdateCustomerRequest;
import com.cars24.csms.data.responses.CreateCustomerResponse;
import com.cars24.csms.data.responses.DeleteCustomerResponse;
import com.cars24.csms.data.responses.UpdateCustomerResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public interface CustomerService {
    public CreateCustomerResponse createCustomerResponse(CreateCustomerRequest createCustomerRequest);
    public CustomerEntity getCustomerDetails(GetCustomerRequest getCustomerRequest);
    public UpdateCustomerResponse updateCustomerResponse(String email, String phone, UpdateCustomerRequest updateCustomerRequest);
    public DeleteCustomerResponse deleteCustomerDetails(DeleteCustomerRequest deleteCustomerRequest);
}
