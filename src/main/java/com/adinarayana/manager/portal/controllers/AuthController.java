package com.adinarayana.manager.portal.controllers;

import com.adinarayana.manager.portal.config.JwtUtil;
import com.adinarayana.manager.portal.models.AuthRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin("http://localhost:3000")
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{
        log.trace("Request to generate token with data " + authRequest.toString());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        }catch (Exception ex){
            throw new Exception("invalid usernme/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}
