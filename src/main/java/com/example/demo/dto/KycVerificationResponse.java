package com.example.demo.dto;

import java.util.UUID;

public class KycVerificationResponse {

    private boolean passed_checks;
    private UUID response_id;

    public KycVerificationResponse(boolean passed_checks) {
        this.passed_checks = passed_checks;
    }

    public boolean isPassed_checks() {
        return passed_checks;
    }

    public void setPassed_checks(boolean passed_checks) {
        this.passed_checks = passed_checks;
    }

    public UUID getResponse_id() {
        return response_id;
    }

    public void setResponse_id(UUID response_id) {
        this.response_id = response_id;
    }
}
