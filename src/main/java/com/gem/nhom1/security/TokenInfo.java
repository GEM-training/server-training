package com.gem.nhom1.security;

import com.gem.nhom1.model.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

/**
 * Created by phuongtd on 18/02/2016.
 */
public class TokenInfo {
    private final long created = System.currentTimeMillis();
    private final String token;
    private final User user;

    public TokenInfo(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "TokenInfo{" +
                "token='" + token + '\'' +
                ", userDetails" + user +
                ", created=" + new Date(created) +
                '}';
    }
}
