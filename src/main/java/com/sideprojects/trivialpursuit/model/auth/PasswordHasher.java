package com.sideprojects.trivialpursuit.model.auth;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PasswordHasher
{
    private static final int KEY_LENGTH = 128;
    private static final int WORK_FACTOR = 100000;

    private SecureRandom random;
    
   
    public PasswordHasher() {
        random = new SecureRandom();
    }

    public String computeHash(String clearTextPassword, byte[] salt) {
        Key key = createKey(clearTextPassword, salt);
        byte[] digest = key.getEncoded();
        return new String(Base64.encode(digest));
    }

    public byte[] generateRandomSalt() {
        return random.generateSeed(128);
    } 
    
    private Key createKey(String password, byte[] salt) {
        SecretKeyFactory factory = getSecretKeyFactory();
        KeySpec keyspec = new PBEKeySpec(password.toCharArray(), salt, WORK_FACTOR, KEY_LENGTH);
        Key key;
        try {
            key = factory.generateSecret(keyspec);
        } catch (InvalidKeySpecException ex) {
            throw new RuntimeException("Ruh roh...", ex);
        }
        return key;
    }

    private SecretKeyFactory getSecretKeyFactory() {
        SecretKeyFactory factory;
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException("Ruh roh...", ex);
        }
        return factory;
    }
}
