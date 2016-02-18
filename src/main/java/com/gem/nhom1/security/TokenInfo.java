package com.gem.nhom1.security;

import com.gem.nhom1.model.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

/**
 * Created by phuongtd on 18/02/2016.
 */
public class TokenInfo{

        private final long TIMEOUT = 24 * 60 * 60 * 1000;
        private long expiration;
        private String token;
        private User user;

        public TokenInfo(String token, User user) {
            this.token = token;
            this.user = user;
            expiration = System.currentTimeMillis() + TIMEOUT;
        }

        public String getToken() {
            return token;
        }

        @Override
        public String toString() {
            return "TokenInfo{" +
                    "token='" + token + '\'' +
                    ", userDetails" + user +
                    ", created=" + new Date(expiration) +
                    '}';
        }


        public long getExpiration() {
            return expiration;
        }

        public void setExpiration(long expiration) {
            this.expiration = expiration;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
}
