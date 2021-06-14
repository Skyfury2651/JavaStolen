package com.example.hellospring.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    @Autowired
    private static PasswordEncoder passwordEncoder;

    public static String convertLongToDate(long time) {
        Date date = new Date(time);
        Format format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(date);
    }

}
