package com.cars24.csms.advice;

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
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<ApiResponse> handleValidationExceptions(MethodArgumentNotValidException exception)
    {
        log.info("[handleValidationExceptions]");

        Map<String,String> errorMap=new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error->
        {
//            System.out.println(error.getDefaultMessage());

            errorMap.put(error.getField(),error.getDefaultMessage());

        });
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatuscode(HttpStatus.BAD_REQUEST.value());
        apiResponse.setSuccess(false);
        apiResponse.setMessage("Invalid signup data");
        apiResponse.setService("APPUSR - " + HttpStatus.BAD_REQUEST.value());
        apiResponse.setData(errorMap);

        return ResponseEntity.badRequest().body(apiResponse);


//        return errorMap;
    }







}
