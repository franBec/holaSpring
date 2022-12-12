package com.example.holaspring.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptPassword {
    public static void main(String[] args) {
        String password = "123";
        System.out.println("password: "+password);
        System.out.println("encriptacion: "+encryptPassword(password));
    }

    public static String encryptPassword(String password){
        return new BCryptPasswordEncoder().encode(password);
    }
}
