package com.carros.util;

import java.util.regex.Pattern;

import java.util.regex.Matcher;

public abstract class ValidaPlaca {
    public static boolean validaPlaca(String placa) {
        String regex = "^[A-Z]{3}-\\d{4}$|^[A-Z]{3}\\d[A-Z]\\d{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(placa);
        return matcher.matches();
    }

}
