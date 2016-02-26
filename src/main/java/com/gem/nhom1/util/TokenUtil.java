package com.gem.nhom1.util;

import com.gem.nhom1.model.entities.User;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by vanhop on 2/17/16.
 */
public class TokenUtil {

    public static String generateAccessToken(User user, String deviceId){

        String str = user.getUsername() + user.getPassword() + System.currentTimeMillis() + deviceId;

        MessageDigest crypt;
        try{
            crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(str.getBytes("UTF-8"));
            return new BigInteger(1, crypt.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NullPointerException e){

        }
        return str;
    }

    /*public static boolean isExpiration(TokenInfo tokenInfo){
        if(tokenInfo == null)
            return false;
        return tokenInfo.getExpirationTime() < System.currentTimeMillis() ? true : false;
    }*/

}
