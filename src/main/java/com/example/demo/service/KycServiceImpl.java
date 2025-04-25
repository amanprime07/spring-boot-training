package com.example.demo.service;

import com.example.demo.dto.KycVerificationRequest;
import com.example.demo.dto.KycVerificationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class KycServiceImpl implements KycService {

    private RestTemplate restTemplate;

    @Value("kyc.base.url")
    private String kycBaseUrl;

    @Value("kyc.api.key")
    private String apiKey;

    public KycServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public KycVerificationResponse verifyKyc(KycVerificationRequest request) {
        // verify kyc
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey);
            HttpEntity<KycVerificationRequest> entity = new HttpEntity<>(request, headers);
            ResponseEntity<KycVerificationResponse> responseEntity = restTemplate.postForEntity(kycBaseUrl + "/verify", entity, KycVerificationResponse.class);
            return responseEntity.getBody();
        } catch (RestClientException rce){
            // handle rest


        } catch (Exception exception){
            // catch all
        }
        return new KycVerificationResponse(false);
    }
}
