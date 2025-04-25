package com.example.demo.service;

import com.example.demo.dto.KycVerificationRequest;
import com.example.demo.dto.KycVerificationResponse;

public interface KycService {

    KycVerificationResponse verifyKyc(KycVerificationRequest request);
}
