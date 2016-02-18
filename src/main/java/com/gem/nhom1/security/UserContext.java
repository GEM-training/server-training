package com.gem.nhom1.security;

import com.gem.nhom1.model.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by phuongtd on 18/02/2016.
 */
public class UserContext implements UserDetails {
    private User  user;

    public UserContext(User user) {
       this.user = user;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

        if(this.user.getCustomer() != null){
            authorities.add(new SimpleGrantedAuthority("Customer"));
        }
        if(this.user.getDealer() != null){
            authorities.add(new SimpleGrantedAuthority("Dealer"));
        }
        if(this.user.getStaff() != null){
            authorities.add(new SimpleGrantedAuthority("Staff"));
        }

        return authorities;
    }

    public String getPassword() {
        return this.user.getPassword();
    }

    public String getUsername() {
        return this.user.getUsername();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return this == o
                || o != null && o instanceof UserContext
                && Objects.equals(user, ((UserContext) o).user);
    }
}
