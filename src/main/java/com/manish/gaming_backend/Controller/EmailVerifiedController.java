package com.manish.gaming_backend.Controller;

import com.manish.gaming_backend.Service.EmailVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
This controller is can be used when we want to varify email
 */

@RestController
@RequestMapping("/email verification")
public class EmailVerifiedController {

    @Autowired
    private EmailVerifyService emailVerifyService;

    @PostMapping("/send")
    public String sendOtp(@RequestParam String email) {
        emailVerifyService.generateAndSendOtp(email);
        return "OTP sent to " + email;
    }

    @PostMapping("/verify")
    public String verifyOtp(@RequestParam String email, @RequestParam String otp) {
        boolean isValid = emailVerifyService.verifyOtp(email, otp);
        return isValid ? "OTP Verified Successfully!" : "Invalid or Expired OTP!";
    }



}
