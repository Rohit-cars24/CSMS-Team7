package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.impl.CustomerDaoImpl;
import com.cars24.csms.data.entities.CustomerEntity;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.repositories.CustomerRepository;
import com.cars24.csms.data.requests.CreateCustomerRequest;
import com.cars24.csms.data.requests.DeleteCustomerRequest;
import com.cars24.csms.data.requests.GetCustomerRequest;
import com.cars24.csms.data.requests.UpdateCustomerRequest;
import com.cars24.csms.data.responses.CreateCustomerResponse;
import com.cars24.csms.data.responses.DeleteCustomerResponse;
import com.cars24.csms.data.responses.UpdateCustomerResponse;
import com.cars24.csms.exceptions.CustomerServiceException;
import com.cars24.csms.exceptions.ProfileExistException;
import com.cars24.csms.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceimpl implements CustomerService {

    private final CustomerDaoImpl customerDaoImpl;
    private final AppUserRepository appUserRepository;
    private final CustomerRepository customerRepository;


    @Override
    public CreateCustomerResponse createCustomerResponse(CreateCustomerRequest createCustomerRequest) {
        boolean userIdFlag=appUserRepository.existsByUsername(createCustomerRequest.getEmail());
        boolean userProfileFlag=customerRepository.existsByEmail(createCustomerRequest.getEmail());
        if(userIdFlag) {
            if(!userProfileFlag) {
                customerDaoImpl.createCustomer(createCustomerRequest);
            }
            else{
                throw new ProfileExistException("This Profile already exists");
            }
        }
        else{
            throw new CustomerServiceException("At first create a user id(Sign up)");
        }
        return null;

    }

    @Override
    public CustomerEntity getCustomerDetails(GetCustomerRequest getCustomerRequest) {
        CustomerEntity resp= null;
        try {
            resp = customerDaoImpl.getCustomer(getCustomerRequest);
        } catch (Exception e) {
            throw new CustomerServiceException("Customer not found with given credentials ");
        }
        return resp;
    }

    @Override
    public UpdateCustomerResponse updateCustomerResponse(String email, String phone,UpdateCustomerRequest updateCustomerRequest) {
        return customerDaoImpl.updateCustomer(email,phone,updateCustomerRequest);

    }

    @Override
    public DeleteCustomerResponse deleteCustomerDetails(DeleteCustomerRequest deleteCustomerRequest) {
        boolean flag=customerRepository.existsByEmailAndPhone(deleteCustomerRequest.getEmail(),deleteCustomerRequest.getPhone());
        if(flag){
            Optional<CustomerEntity> customerOptional=customerRepository.findByEmailAndPhone(deleteCustomerRequest.getEmail(),deleteCustomerRequest.getPhone());
            CustomerEntity customerEntity1=new CustomerEntity();
            customerEntity1 =customerOptional.get();
            boolean flag2=customerEntity1.isActive();
            if(flag2){
                return customerDaoImpl.deleteCustomer(deleteCustomerRequest);
            }
            else{
                throw new CustomerServiceException("Customer Doesnot exists");
            }
        }
        else{
            throw new CustomerServiceException("Customer Doesnot exists");
        }

    }


}
