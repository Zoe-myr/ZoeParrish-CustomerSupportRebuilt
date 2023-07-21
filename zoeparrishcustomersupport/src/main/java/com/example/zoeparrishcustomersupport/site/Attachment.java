package com.example.zoeparrishcustomersupport.site;

import java.io.Serializable;

public class Attachment implements Serializable {
    private String name;
    private byte[] contents;

    public String getName(){
        return name;
    }
    byte[] getContents(){
        return contents;
    }
    void setName(String n){
        name = n;
    }
    void setContents(byte[] c){
        contents = c;
    }
}
