package com.cars24.csms.data.dao.impl;

import com.cars24.csms.data.dao.CustomerDao;
import com.cars24.csms.data.entities.CustomerEntity;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.repositories.CustomerRepository;
import com.cars24.csms.data.requests.CreateCustomerRequest;
import com.cars24.csms.data.requests.DeleteCustomerRequest;
import com.cars24.csms.data.requests.GetCustomerRequest;
import com.cars24.csms.data.requests.UpdateCustomerRequest;
import com.cars24.csms.data.responses.DeleteCustomerResponse;
import com.cars24.csms.data.responses.UpdateCustomerResponse;
import com.cars24.csms.exceptions.CustomerServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerDaoImpl implements CustomerDao {

    private final CustomerRepository customerRepository;
    private final AppUserRepository appUserRepository;
    CustomerEntity customerEntity=new CustomerEntity();

    @Override
    public int createCustomer(CreateCustomerRequest createCustomerRequest) {

        CustomerEntity customerEntity=new CustomerEntity();
        customerEntity.setName(createCustomerRequest.getName());
        customerEntity.setPhone(createCustomerRequest.getPhone());
        customerEntity.setEmail(createCustomerRequest.getEmail());
        customerEntity.setAddress(createCustomerRequest.getAddress());

        customerEntity.setUserId(appUserRepository.findByUsername(createCustomerRequest.getEmail()).getId());
        customerEntity.setActive(true);
        customerRepository.save(customerEntity);
        return 0;

    }

    @Override
    public CustomerEntity getCustomer(GetCustomerRequest getCustomerRequest) {
        return customerRepository.findByEmailAndPhone(
                getCustomerRequest.getEmail(),
                getCustomerRequest.getPhone()
        ).orElseThrow(() -> new RuntimeException("Customer not found with email: " +
                getCustomerRequest.getEmail() + " and phone: " + getCustomerRequest.getPhone()));
    }

    @Override
    public UpdateCustomerResponse updateCustomer(String email, String phone,UpdateCustomerRequest updateCustomerRequest) {
//Do later
        Optional<CustomerEntity> customerOptional=customerRepository.findByEmailAndPhone(email,phone);
        UpdateCustomerResponse updateCustomerResponse=new UpdateCustomerResponse();
        if (customerOptional.isPresent()) {
            customerEntity = customerOptional.get(); // Retrieve the Customer object
            customerEntity.setName(updateCustomerRequest.getName());
            customerEntity.setPhone(updateCustomerRequest.getPhone());
            customerEntity.setEmail(updateCustomerRequest.getEmail());
            customerEntity.setAddress(updateCustomerRequest.getAddress());
            customerEntity.setActive(true);
            customerRepository.save(customerEntity);
//
        } else{
            throw new CustomerServiceException("Customer Doesnot exists");
        }

        return null;
    }

    @Override
    public DeleteCustomerResponse deleteCustomer(DeleteCustomerRequest deleteCustomerRequest) {
        Optional<CustomerEntity> customerOptional=customerRepository.findByEmailAndPhone(deleteCustomerRequest.getEmail(),deleteCustomerRequest.getPhone());
        CustomerEntity customerEntity1=new CustomerEntity();
        customerEntity1 =customerOptional.get();
        customerEntity1.setActive(false);
        DeleteCustomerResponse deleteCustomerResponse=new DeleteCustomerResponse();
        deleteCustomerResponse.setName(customerEntity1.getName());
        deleteCustomerResponse.setPhone(customerEntity1.getPhone());
        deleteCustomerResponse.setEmail(customerEntity1.getEmail());
        deleteCustomerResponse.setAddress(customerEntity1.getAddress());

        customerRepository.save(customerEntity1);

        return deleteCustomerResponse;
    }

}
