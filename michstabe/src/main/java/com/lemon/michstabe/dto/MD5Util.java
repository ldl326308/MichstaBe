package com.lemon.michstabe.dto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    public static String toMd5(String str){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            char[] chars = str.toCharArray();
            byte[] bytes = new byte[chars.length];
            for (int i = 0; i < chars.length; i++) {
                bytes[i] = (byte) chars[i];
            }
            byte[] digest = md5.digest(bytes);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < digest.length; i++) {
                int val = ((int)digest[i]) & 0xff;
                if (val < 16){
                    stringBuilder.append("0");
                }
                stringBuilder.append(Integer.toHexString(val));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
