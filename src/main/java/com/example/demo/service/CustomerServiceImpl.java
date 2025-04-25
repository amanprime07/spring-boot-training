package com.example.demo.service;


import com.example.demo.dto.CustomerRequestDto;
import com.example.demo.dto.CustomerResponseDto;
import com.example.demo.dto.KycVerificationRequest;
import com.example.demo.dto.KycVerificationResponse;
import com.example.demo.entities.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.utils.CountryNameUtils;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private KycService kycService;

    public CustomerServiceImpl(CustomerRepository customerRepository, KycService kycService) {
        this.customerRepository = customerRepository;
        this.kycService = kycService;
    }

    @Override
    public CustomerResponseDto saveCustomer(CustomerRequestDto customerDto) {
        // verify kyc and save customer
        KycVerificationRequest request = buildKycRequest(customerDto);
        KycVerificationResponse kycResponse = kycService.verifyKyc(request);
        Customer customer = buildCustomer(customerDto);
        Customer customerEntity = customerRepository.save(customer);
        return new CustomerResponseDto();
    }

    private KycVerificationRequest buildKycRequest(CustomerRequestDto customerRequestDto){
        return new KycVerificationRequest(customerRequestDto.getName(), customerRequestDto.getAddress(), CountryNameUtils.countryCode(customerRequestDto.getAddress()));
    }

    private Customer buildCustomer(CustomerRequestDto customerRequestDto){
        Customer customer = new Customer();
        customer.setName(customerRequestDto.getName());
        customer.setAddress(customerRequestDto.getAddress());
        // remaining fields
        return customer;
    }

    private Customer buildCustomerResponse(CustomerRequestDto customerRequestDto){
        Customer customer = new Customer();
        customer.setName(customerRequestDto.getName());
        customer.setAddress(customerRequestDto.getAddress());
        // remaining fields
        return customer;
    }

}
