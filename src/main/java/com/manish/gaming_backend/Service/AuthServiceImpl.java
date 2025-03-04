package com.manish.gaming_backend.Service;

import com.manish.gaming_backend.Model.Role.Admin;
import com.manish.gaming_backend.Model.Role.User;
import com.manish.gaming_backend.Repository.AdminRepository;
import com.manish.gaming_backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    public boolean isEmailExist(String email) {
        User temUser =  userRepository.findByEmail(email);
        if(temUser==null){
            return false;
        }else {
            return true;
        }
    }

    public boolean isPhoneNumberExist(String phone) {
        User temUser =userRepository.findByPhone(phone);
        System.out.println(temUser);
        if(temUser==null){
            return false;
        }else {
            return true;
        }
    }


    public User isSignUpWithUser(User user) throws Exception {
        User save;
        try {
             save = userRepository.save(user);
        }catch (Exception e){
            throw new Exception("Registration failed Try again later");
        }

        return save;
    }
    public Admin isSignUpWithAdmin(Admin admin) throws Exception {
       Admin save;
        try {
            save = adminRepository.save(admin);
        }catch (Exception e){
            throw new Exception("Registration failed Try again later");
        }
        return save;
    }

    @Override
    public User findUserByEmail(String email) {
        User user =  userRepository.findByEmail(email);
        return user;
     }


    @Override
    public Admin findAdminByEmail(String email) {
        return adminRepository.findByEmail(email) ;
    }

    @Override
    public boolean isPhoneNumberExistAsAdmin(String number) {
        return adminRepository.findByNumber(number)!=null;
    }


    public boolean deleteAccountOfAdmin(Long adminId){
        try {
            adminRepository.deleteById(adminId);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean deleteAccountOfUser(Long userId){
        try {
            userRepository.deleteById(userId);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
