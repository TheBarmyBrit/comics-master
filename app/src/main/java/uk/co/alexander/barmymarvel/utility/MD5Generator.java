package uk.co.alexander.barmymarvel.utility;

import java.security.MessageDigest;


public class MD5Generator {
    public static String getMd5Hash(String string) {

        byte[] thedigest = null;
        byte[] bytesOfMessage = new byte[0];
        try {
            bytesOfMessage = string.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5Generator");
            thedigest = md.digest(bytesOfMessage);
        } catch (Exception e) {
            throw new RuntimeException("Error computing hash : "+e.getMessage());
        }

        StringBuilder sb = new StringBuilder(2 * thedigest.length);
        for (byte b : thedigest) {
            sb.append("0123456789abcdef".charAt((b & 0xF0) >> 4));
            sb.append("0123456789abcdef".charAt((b & 0x0F)));
        }

        return sb.toString();
    }
}
