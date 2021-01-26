package com.ruize.api.authenticator.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SHAUtil {

    public static final String SHA_256 = "SHA-256";

    public static String SHA(String msg) throws NoSuchAlgorithmException {
        MessageDigest sha256 = null;
        sha256 = MessageDigest.getInstance(SHA_256);
        sha256.update(msg.getBytes());
        byte[] sha256Bin = sha256.digest();
        byte[] base64 = Base64.getEncoder().encode(sha256Bin);
        return new String(base64);
    }
}