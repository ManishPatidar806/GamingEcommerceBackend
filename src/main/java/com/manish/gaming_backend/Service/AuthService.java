package com.manish.gaming_backend.Service;

import com.manish.gaming_backend.Model.Role.Admin;
import com.manish.gaming_backend.Model.Role.User;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    public boolean isEmailExist(String email);
    public boolean isPhoneNumberExist(String number);
    public User isSignUpWithUser(User user) throws Exception;

    public  Admin isSignUpWithAdmin(Admin admin) throws Exception;
    public User findUserByEmail(String email);

    public Admin findAdminByEmail(String email);

    public boolean isPhoneNumberExistAsAdmin(String number);

    public boolean deleteAccountOfUser(Long userId);

    public boolean deleteAccountOfAdmin(Long adminId);



}
