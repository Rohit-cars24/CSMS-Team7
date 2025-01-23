package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.CustomerEntity;
import com.cars24.csms.data.requests.CreateCustomerRequest;
import com.cars24.csms.data.requests.DeleteCustomerRequest;
import com.cars24.csms.data.requests.GetCustomerRequest;
import com.cars24.csms.data.requests.UpdateCustomerRequest;
import com.cars24.csms.data.responses.DeleteCustomerResponse;
import com.cars24.csms.data.responses.UpdateCustomerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CustomerDao {
    public int createCustomer(CreateCustomerRequest createCustomerRequest);
    public CustomerEntity getCustomer(GetCustomerRequest getCustomerRequest);
    public UpdateCustomerResponse updateCustomer(String email, String phone,UpdateCustomerRequest updateCustomerRequest);

    DeleteCustomerResponse deleteCustomer(DeleteCustomerRequest deleteCustomerRequest);
}
