package com.portfolio.jepc.Security.DTO;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Joaco
 */
public class JwtDTO {
    private String token;
    private String bearer = "Bearer";
    private String username;
    private Collection<? extends GrantedAuthority> authorities;

    //Constructor
        public JwtDTO(String token, String userName, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.username = username;
        this.authorities = authorities;
    }
    //Getters&Setters

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = username;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
        
     
}
