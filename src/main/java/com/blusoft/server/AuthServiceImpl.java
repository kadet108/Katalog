package com.blusoft.server;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.blusoft.client.AuthService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class AuthServiceImpl extends RemoteServiceServlet implements AuthService {

    public String retrieveUsername() {
        
        Authentication authentication =
            SecurityContextHolder.getContext().getAuthentication();
        
        if (authentication==null){
            System.out.println("Not logged in");
            return null;
        }
        else {
            return (String) authentication.getPrincipal();
        }
        
    }
    
}