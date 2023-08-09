package com.example.zoeparrishcustomersupport.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="attachments")
public class Attachment implements Serializable {

    private static final long serialVersionUID = 1L;
    private long id;


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    private long ticketId;
    private String name;
    private byte[] contents;

    @Basic
    public String getName(){
        return name;
    }

    @Lob
    public byte[] getContents(){
        return contents;
    }

    public void setName(String n){
        name = n;
    }

    public void setContents(byte[] c){
        contents = c;
    }
}
