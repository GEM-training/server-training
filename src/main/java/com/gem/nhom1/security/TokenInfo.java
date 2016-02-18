package com.gem.nhom1.security;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

/**
 * Created by phuongtd on 18/02/2016.
 */
public class TokenInfo {
    private final long created = System.currentTimeMillis();
    private final String token;
    private final UserDetails userDetails;

    public TokenInfo(String token, UserDetails userDetails) {
        this.token = token;
        this.userDetails = userDetails;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "TokenInfo{" +
                "token='" + token + '\'' +
                ", userDetails" + userDetails +
                ", created=" + new Date(created) +
                '}';
    }
}
