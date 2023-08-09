package com.example.zoeparrishcustomersupport.site;

import com.example.zoeparrishcustomersupport.entities.Attachment;

import java.util.List;

public interface AttachmentRepository extends GenericRepository<Long, Attachment>{

    List<Attachment> getByTicketID(Long ticketId);
}
