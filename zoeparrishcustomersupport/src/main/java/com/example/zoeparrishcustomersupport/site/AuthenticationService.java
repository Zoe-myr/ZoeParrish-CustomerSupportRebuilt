package com.example.zoeparrishcustomersupport.site;

import com.example.zoeparrishcustomersupport.entities.UserPrinciple;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    UserPrinciple authenticate(String username,String Password);

}
