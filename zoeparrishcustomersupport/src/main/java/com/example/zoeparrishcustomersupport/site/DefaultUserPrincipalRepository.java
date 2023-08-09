package com.example.zoeparrishcustomersupport.site;

import com.example.zoeparrishcustomersupport.entities.UserPrinciple;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultUserPrincipalRepository extends GenericJpaRepository<Long, UserPrinciple> implements UserPrincipleRepository {
    @Override
    public UserPrinciple getByUsername(String username) {
        return  this.entityManager.createQuery("SELECT u FROM UserPrinciple u WHERE u.username = :username",
                UserPrinciple.class).setParameter("username",username).getSingleResult();
    }
}
