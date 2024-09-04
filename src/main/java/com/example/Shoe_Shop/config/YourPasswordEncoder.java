package com.example.Shoe_Shop.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class YourPasswordEncoder implements PasswordEncoder {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public YourPasswordEncoder() {
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public String encode(CharSequence rawPassword) {
        // Mã hóa mật khẩu bằng cách sử dụng BCryptPasswordEncoder
        return bCryptPasswordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        // So sánh mật khẩu rõ với mật khẩu đã được mã hóa
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
    }
}