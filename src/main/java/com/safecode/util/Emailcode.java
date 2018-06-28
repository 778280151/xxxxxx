package com.safecode.util;

import java.util.Random;

public class Emailcode {
    String ValidateCode;

    public static String GetCode() {
        char[] value = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        String str = "";
        Random random = new Random();
        char[] c = new char[6];
        for (int i = 0; i < 6; i++) {
            c[i] = value[random.nextInt(36)];
        }
        str = String.valueOf(c);
        return str;
    }

}
