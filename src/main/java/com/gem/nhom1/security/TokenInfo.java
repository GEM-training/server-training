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
    private String deviceId;
    private User user;

    public TokenInfo(String token, String deviceId, User user) {
        this.access_token = token;
        this.user = user;
        this.deviceId = deviceId;
        expirationTime = System.currentTimeMillis() + TIMEOUT;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
