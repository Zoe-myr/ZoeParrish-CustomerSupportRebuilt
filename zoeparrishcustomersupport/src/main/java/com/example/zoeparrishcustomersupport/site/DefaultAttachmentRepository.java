package com.example.zoeparrishcustomersupport.site;

import com.example.zoeparrishcustomersupport.entities.Attachment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DefaultAttachmentRepository extends GenericJpaRepository<Long, Attachment> implements AttachmentRepository {
    @Override
    public List<Attachment> getByTicketID(Long ticketId) {
            return this.entityManager.createQuery("SELECT i FROM Attachment i WHERE i.ticketId = :id", Attachment.class).setParameter("id",ticketId).getResultList();

    }
}
