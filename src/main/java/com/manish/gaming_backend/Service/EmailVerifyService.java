package com.manish.gaming_backend.Service;

import org.springframework.stereotype.Service;

@Service
public interface EmailVerifyService {
    public void generateAndSendOtp(String email);
    public boolean verifyOtp(String email, String otp);

    public void cleanupExpiredOtps();
}
