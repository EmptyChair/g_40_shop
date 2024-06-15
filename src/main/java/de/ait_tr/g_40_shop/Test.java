package de.ait_tr.g_40_shop;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

    public static void main(String[] args) {
        //get encrypted form of password

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pass = "111";
        String encodedPass = encoder.encode(pass);
        System.out.println(encodedPass);
    }
}
