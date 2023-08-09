package com.example.zoeparrishcustomersupport.site;

import com.example.zoeparrishcustomersupport.entities.UserPrinciple;

public interface UserPrincipleRepository extends GenericRepository<Long, UserPrinciple>{
    UserPrinciple getByUsername(String username);
}
