package com.gem.nhom1.security;

import com.gem.nhom1.util.TokenUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by vanhop on 2/17/16.
 */
@Service
public class TokenManager{

    private HashMap<String, TokenInfo> tokens;
    private static TokenManager tokenManager;

    private TokenManager(){
        tokens = new HashMap<String, TokenInfo>();
    }

    public static TokenManager getInstaince(){
        if(tokenManager == null)
            tokenManager = new TokenManager();
        return tokenManager;
    }

    public void addToken(TokenInfo tokenInfo) {
        tokens.put(tokenInfo.getAccess_token(), tokenInfo);
    }

    public String updateToken(TokenInfo tokenInfo) {
        tokens.remove(tokenInfo.getAccess_token());
        String new_acc = null;
        new_acc = TokenUtil.generateAccessToken(tokenInfo.getUser(),tokenInfo.getDeviceId());
        tokenInfo.setAccess_token(new_acc);
        tokens.put(new_acc, tokenInfo);
        return new_acc;
    }

    public TokenInfo get(String access_token) {
        return tokens.get(access_token);
    }

    public void deleteToken(String accees_token){
        tokens.remove(accees_token);
    }
}
