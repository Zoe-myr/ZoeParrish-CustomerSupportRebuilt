package com.example.zoeparrishcustomersupport.entities;


import jakarta.persistence.*;
import jakarta.servlet.http.HttpSession;

import javax.security.auth.Subject;
import java.io.Serializable;
import java.security.Principal;

@Entity
@Table(name="users")
public class UserPrinciple implements Principal, Serializable {
    private static final long serialVersionUID = 1L;
    private static  final String SESSION_ATTRIBUTE_KEY = "com.example.zoeparrishcustomersupport.userprincipal.principal";

    private long id;
    private String username;
    private byte[] password;


    @Id
    @Column(name="id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    @Basic
    @Column(name="hashedpassword")
    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    @Override
    public String toString() {
        return username;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj  instanceof UserPrinciple){
            UserPrinciple user = (UserPrinciple) obj;
            return user.getUsername().equals(username);
        }
        return false;
    }

    public static Principal getPrincipal(HttpSession session) {
        return session == null ? null : (Principal)session.getAttribute(SESSION_ATTRIBUTE_KEY);
    }

    public static void setPrincipal(HttpSession session, Principal principal){
        session.setAttribute(SESSION_ATTRIBUTE_KEY,principal);
    }

    @Override
    @Transient
    public String getName() {
        return username;
    }

    @Override
    public boolean implies(Subject subject) {
        return Principal.super.implies(subject);
    }
}
