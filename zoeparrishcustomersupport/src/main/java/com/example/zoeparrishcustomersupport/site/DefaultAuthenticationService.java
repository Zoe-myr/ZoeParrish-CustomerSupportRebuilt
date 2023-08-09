package com.example.zoeparrishcustomersupport.site;

import com.example.zoeparrishcustomersupport.entities.UserPrinciple;
import jakarta.inject.Inject;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;


@Service
public class DefaultAuthenticationService implements  AuthenticationService{
    private static final SecureRandom RANDOM;
    private static final int HASHING_ROUNDS = 10;

    static {
        try {
            RANDOM = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    @Inject UserPrincipleRepository userRepo;
    @Override
    public UserPrinciple authenticate(String username, String password) {
        UserPrinciple principle = userRepo.getByUsername(username);
        if (principle == null){
            return null;
        }
        if(!BCrypt.checkpw(password, new String(principle.getPassword(),StandardCharsets.UTF_8))){
            return null;
        }
        return principle;
    }
}
