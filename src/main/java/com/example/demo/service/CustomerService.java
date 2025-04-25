package com.example.demo.service;

import com.example.demo.dto.CustomerRequestDto;
import com.example.demo.dto.CustomerResponseDto;

public interface CustomerService {

    CustomerResponseDto saveCustomer(CustomerRequestDto customerDto);
}
