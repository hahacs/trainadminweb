package com.system.admin.config.security;

import com.system.admin.util.MD5Util;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordConfig implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        //charSequence是用户输入的密码，password是存库的密码
        return MD5Util.getMD5(charSequence.toString());
    }

    @Override
    public boolean matches(CharSequence charSequence, String password) {
        return password.contentEquals(encode(charSequence));
    }
}
