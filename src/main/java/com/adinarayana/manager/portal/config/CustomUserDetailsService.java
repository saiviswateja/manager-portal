package com.adinarayana.manager.portal.config;

import com.adinarayana.manager.portal.models.Manager;
import com.adinarayana.manager.portal.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        Manager manager = managerRepository.findByEmailId(emailId);
        return new org.springframework.security.core.userdetails.User(manager.getEmailId(),manager.getPassword(),new ArrayList<>());
    }
}
