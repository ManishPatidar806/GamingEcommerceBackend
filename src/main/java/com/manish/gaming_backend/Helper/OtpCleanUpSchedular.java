package com.manish.gaming_backend.Helper;
import com.manish.gaming_backend.Service.EmailVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class OtpCleanUpSchedular {

        @Autowired
        private EmailVerifyService emailVerifyService;

        @Scheduled(fixedRate = 120000) // Run every 3 minutes
        public void cleanExpiredOtps() {
            emailVerifyService.cleanupExpiredOtps();
            System.out.println("Expired OTPs cleaned up.");
        }
    }


