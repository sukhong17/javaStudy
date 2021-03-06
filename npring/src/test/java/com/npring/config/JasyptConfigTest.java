package com.npring.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JasyptConfigTest {


    @Test
    @DisplayName("DB 암호화 처리")
    void jasypt() {
        String username = "admin";
        String password = "admin123";
        System.out.println("username = " + jasyptEncoding(username));
        System.out.println("jasypt = " + jasyptEncoding(password));
    }

    public String jasyptEncoding(String value) {

        String key = "kimsunho";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword(key);
        return pbeEnc.encrypt(value);
    }

}