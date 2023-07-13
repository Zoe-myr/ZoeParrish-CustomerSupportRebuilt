package com.example.zoeparrishcustomersupport;

import com.example.zoeparrishcustomersupport.Attachment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AttachmentTest {
    Attachment a = new Attachment();

    @Test
    void testContents(){
        byte[] t = new byte[0];
        a.setContents(t);
        assertEquals(t,a.getContents());
    }
    @Test
    void testName(){
        a.setName("jeff");
        assertEquals("jeff",a.getName());
    }
}