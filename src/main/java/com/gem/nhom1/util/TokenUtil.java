package com.gem.nhom1.util;

import com.gem.nhom1.model.entities.User;
import com.gem.nhom1.security.TokenInfo;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by vanhop on 2/17/16.
 */
public class TokenUtil {

    public static String generateAccessToken(User user) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        String str = user.getUsername() + user.getPassword() + System.currentTimeMillis();

        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(str.getBytes("UTF-8"));

        return new BigInteger(1, crypt.digest()).toString(16);
    }

    public static boolean isExpiration(TokenInfo tokenInfo){
        if(tokenInfo == null)
            return false;
        return tokenInfo.getExpirationTime() < System.currentTimeMillis() ? true : false;
    }

}
