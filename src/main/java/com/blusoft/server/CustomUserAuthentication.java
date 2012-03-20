package com.blusoft.server;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

public class CustomUserAuthentication implements Authentication {
    
    private static final long serialVersionUID = -3091441742758356129L;
    
    private boolean authenticated;
    
    private GrantedAuthority grantedAuthority;
    private Authentication authentication;
    
    public CustomUserAuthentication(String role, Authentication authentication) {
        this.grantedAuthority = new GrantedAuthorityImpl(role);
        this.authentication = authentication;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(grantedAuthority);
        return authorities;
    }

    public Object getCredentials() {
        return authentication.getCredentials();
    }

    public Object getDetails() {
        return authentication.getDetails();
    }

    public Object getPrincipal() {
        return authentication.getPrincipal();
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
        this.authenticated = authenticated;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

}