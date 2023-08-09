package com.example.zoeparrishcustomersupport.site;

import com.example.zoeparrishcustomersupport.entities.Attachment;

import java.util.Collection;
import java.util.HashMap;

public class Ticket {
    //fields
    String customerName;
    String subject;
    String body;
    HashMap<Integer, Attachment> attachments = new HashMap<>();

    public Ticket(String customerName, String subject, String body, HashMap<Integer,Attachment> attachments){
        this.customerName = customerName;
        this.subject = subject;
        this.body = body;
        this.attachments = attachments;
    }
    public Ticket(){}

    //basic get/set
    public void setCustomerName(String n){
        customerName = n;
    }
    public String getCustomerName(){
        return customerName;
    }
    public void setSubject(String s){
        subject = s;
    }
    public String getSubject(){
        return subject;
    }
    public void setBody(String b){
        body = b;
    }
    public String getBody(){
        return body;
    }
    public void setAttachments(HashMap<Integer, Attachment> a) {
        this.attachments = a;
    }
    public Collection<Attachment> getAttachments(){
        return this.attachments.values();
    }

    //gets # of attachments
    public int getNumOfAttachments(){
        return attachments.size();
    }

    //adds an attachment
    void addAttachment(Attachment a) {
        if (this.attachments == null) {
            attachments.put(0, a);
        } else {
            attachments.put(attachments.size(), a);
        }
    }
    //gets an attachment specified by the id
    Attachment getAttachment(int x){
        return attachments.get(x);
    }

    //get all attachments in a collection
    Collection<Attachment> getAllAttachments(){
        return attachments.values();
    }
}
