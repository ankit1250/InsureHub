package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dto.ForgotPasswordRequest;
import com.entity.UserCredential;
import com.repository.UserCredentialRepository;

@Service
public class AuthService {

    @Autowired
    private UserCredentialRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String saveUser(UserCredential credential) {
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        repository.save(credential);
        return "user added to the system";
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
    
    public boolean changePassword(ForgotPasswordRequest fpr) {
    	Optional<UserCredential> userCredOp = repository.findByUsername(fpr.getUsername());
    	if(!userCredOp.isPresent())return false;
    	UserCredential userCred = userCredOp.get();
    	if(fpr.getSecurityQuestion().equals(userCred.getSecurityQuestion()) && fpr.getSecurityAnswer().equals(userCred.getSecurityAnswer())) {
    		userCred.setPassword(passwordEncoder.encode(fpr.getNewPassword()));
    		repository.save(userCred);
    		return true;
    	}
    	return false;
    	
    	
    }
    
    public Long getUserIdFromToken(String token) {
    	String userName = jwtService.extractUsername(token);
    	Optional<UserCredential> userCred = repository.findByUsername(userName);
    	if(userCred.isPresent()) {
    		return (long) userCred.get().getId();
    	}
    	return (long)-1;
    }


}
