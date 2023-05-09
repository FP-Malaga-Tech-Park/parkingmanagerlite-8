package com.hormigo.david.parkingmanager.user.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.hormigo.david.parkingmanager.core.exceptions.UserDoesNotExistsException;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        com.hormigo.david.parkingmanager.user.domain.User user = null;
        try {
            user = userService.getByEmail(username);
        }
        catch (UserDoesNotExistsException ex) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails details = User.withUsername(user.getEmail())
            .password(user.getPassword())
            .accountExpired(user.isExpired())
            .accountLocked(user.isLocked())
            .disabled(!user.isVerified())
            .roles(user.getRole().toString())
            .build();
        return details;
            
        
    }
    
}