package com.example.zoeparrishcustomersupport.site;

import com.example.zoeparrishcustomersupport.entities.Attachment;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //fields
    long id;
    String customerName;
    String subject;
    String body;
    List<Attachment> attachments = new ArrayList<>();

    public Ticket(String customerName, String subject, String body, List<Attachment> attachments){
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
    public void setAttachments(List<Attachment> a) {
        this.attachments = a;
    }
    public List<Attachment> getAttachments(){
        return this.attachments;
    }

    //gets # of attachments
    public int getNumOfAttachments(){
        return attachments.size();
    }

    //adds an attachment
    void addAttachment(Attachment a) {

        attachments.add(a);
    }
    //gets an attachment specified by the id
    Attachment getAttachment(int x){
        return attachments.get(x);
    }

}
