package com.cars24.csms.advice;


import com.cars24.csms.exceptions.AppointmentServiceException;
import com.cars24.csms.exceptions.EmployeeServiceException;
import com.cars24.csms.exceptions.UserServiceException;
import com.cars24.csms.data.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j

class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException exception) {
        ApiResponse apiResponse = new ApiResponse();

        log.info("[handleValidationExceptions]");

        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error ->
        {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.ok().body(errorMap);
    }

    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<ApiResponse> handleUserServiceExceptions(UserServiceException exception) {

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatuscode(HttpStatus.BAD_REQUEST.value());
        apiResponse.setSuccess(false);
        apiResponse.setMessage(exception.getMessage());
        apiResponse.setService("AppUsr " + HttpStatus.BAD_REQUEST.value());
        apiResponse.setData(null);
        return ResponseEntity.ok().body(apiResponse);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleInvalidDateFormat(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AppointmentServiceException.class)
    public ResponseEntity<ApiResponse> handleAppointmentServiceExceptions(AppointmentServiceException exception) {

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatuscode(HttpStatus.BAD_REQUEST.value());
        apiResponse.setSuccess(false);
        apiResponse.setMessage(exception.getMessage());
        apiResponse.setService("AppUsr " + HttpStatus.BAD_REQUEST.value());
        apiResponse.setData(null);
        return ResponseEntity.ok().body(apiResponse);
    }

    @ExceptionHandler(EmployeeServiceException.class)
    public  ResponseEntity<ApiResponse> handleEmployeeServiceExceptions(EmployeeServiceException employeeServiceException)
    {
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        apiResponse.setSuccess(false);
        apiResponse.setMessage(employeeServiceException.getMessage());
        apiResponse.setService("EMPSRVC-" + HttpStatus.BAD_REQUEST.value());
        apiResponse.setData(null);
        return ResponseEntity.ok().body(apiResponse);

    }

}