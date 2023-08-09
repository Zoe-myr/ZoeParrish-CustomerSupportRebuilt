package com.example.zoeparrishcustomersupport.site;

import com.example.zoeparrishcustomersupport.entities.Attachment;

import java.util.List;

public class DefaultAttachmentRepository extends GenericJpaRepository<Long, Attachment> implements AttachmentRepository {
    @Override
    public List<Attachment> getByTicketID(Long ticketId) {
        try{
            return this.entityManager.createQuery("SELECT i FROM Attachment WHERE i.ticketId = :id", Attachment.class).setParameter("id",ticketId).getResultList();
        }catch(Exception e){
            return null;
        }
    }
}
