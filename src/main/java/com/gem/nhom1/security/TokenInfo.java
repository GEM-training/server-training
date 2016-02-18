package com.gem.nhom1.security;

import com.gem.nhom1.model.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

/**
 * Created by phuongtd on 18/02/2016.
 */
public class TokenInfo {

    private final long TIMEOUT = 60 * 60 * 1000;
    private long expirationTime;
    private String access_token;
    private User user;

    public TokenInfo(String token, User user) {
        this.access_token = token;
        this.user = user;
        expirationTime = System.currentTimeMillis() + TIMEOUT;
    }

    public String getToken() {
        return access_token;
    }

    @Override
    public String toString() {
        return "TokenInfo{" +
                "token='" + access_token + '\'' +
                ", userDetails" + user +
                ", created=" + new Date(expirationTime) +
                '}';
    }


    public long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public void setToken(String token) {
        this.access_token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
