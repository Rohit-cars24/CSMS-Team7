package com.cars24.csms.controllers;

import com.cars24.csms.data.entities.CustomerEntity;
import com.cars24.csms.data.requests.CreateCustomerRequest;
import com.cars24.csms.data.requests.DeleteCustomerRequest;
import com.cars24.csms.data.requests.GetCustomerRequest;
import com.cars24.csms.data.requests.UpdateCustomerRequest;
import com.cars24.csms.data.responses.CreateCustomerResponse;
import com.cars24.csms.data.responses.DeleteCustomerResponse;
import com.cars24.csms.data.responses.UpdateCustomerResponse;
import com.cars24.csms.services.impl.CustomerServiceimpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/customer")
@Validated
@Slf4j
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServiceimpl customerServiceImpl;
    @PostMapping
    public ResponseEntity<CreateCustomerResponse> createCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest){
        customerServiceImpl.createCustomerResponse(createCustomerRequest);
        log.info("[createCustomer] createCustomerRequest {}",createCustomerRequest);
        CreateCustomerResponse createCustomerResponse = new CreateCustomerResponse();
        return ResponseEntity.ok().body(createCustomerResponse);
    }


    @GetMapping
    public ResponseEntity<CustomerEntity> getCustomerDetails(@RequestParam String email ,@RequestParam String phone){
        GetCustomerRequest getCustomerRequest=new GetCustomerRequest();
        getCustomerRequest.setPhone(phone);
        getCustomerRequest.setEmail(email);

        CustomerEntity resp=customerServiceImpl.getCustomerDetails(getCustomerRequest);
        return ResponseEntity.ok(resp);

    }

    @PutMapping
    public ResponseEntity<UpdateCustomerResponse> updateCustomer(@Valid @RequestParam String email, @RequestParam String phone, @RequestBody UpdateCustomerRequest updateCustomerRequest){
        UpdateCustomerResponse updateCustomerResponse = customerServiceImpl.updateCustomerResponse(email,phone,updateCustomerRequest);

        log.info(" [updateCustomer] updateCustomerRequest {}",updateCustomerRequest);

        return ResponseEntity.ok().body(updateCustomerResponse);
    }

    @DeleteMapping
    public ResponseEntity<DeleteCustomerResponse> deleteCustomer(@Valid @RequestParam String email , @RequestParam String phone){
        DeleteCustomerRequest deleteCustomerRequest=new DeleteCustomerRequest();
        deleteCustomerRequest.setEmail(email);
        deleteCustomerRequest.setPhone(phone);
        return ResponseEntity.ok().body(customerServiceImpl.deleteCustomerDetails(deleteCustomerRequest));

    }

}


