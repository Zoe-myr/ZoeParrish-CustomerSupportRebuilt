package com.example.zoeparrishcustomersupport.site;

import com.example.zoeparrishcustomersupport.entities.Attachment;
import com.example.zoeparrishcustomersupport.entities.TicketEntity;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultTicketService implements TicketService{

    @Inject TicketRepository ticketRepository;
    @Inject AttachmentRepository attachmentRepository;


    @Override
    public List<Ticket> getAllTickets() {
        List<Ticket> list = new ArrayList<>();
        ticketRepository.getAll().forEach(e -> list.add(this.convert(e)));
        return list;
    }
    @Override
    public Ticket getTicket(long id) {
        TicketEntity entity = ticketRepository.get(id);
        if(entity == null){
            return null;
        }else{
            return this.convert(entity);
        }
    }

    private Ticket convert(TicketEntity e){
            Ticket ticket = new Ticket();
            ticket.setId(e.getId());
            ticket.setSubject(e.getSubject());
            ticket.setBody(e.getBody());
            ticket.setCustomerName(e.getCustomerName());
            ticket.setAttachments(attachmentRepository.getByTicketID(e.getId()));
            return ticket;
        }

    @Override
    @Transactional
    public void save(Ticket ticket) {
        TicketEntity entity = new TicketEntity();
        entity.setBody(ticket.getBody());
        entity.setId(ticket.getId());
        entity.setSubject(ticket.getSubject());
        entity.setCustomerName(ticket.getCustomerName());

        ticketRepository.add(entity);
        ticket.setId(entity.getId());

        for ( Attachment a: ticket.getAttachments()){
            a.setTicketId(entity.getId());
            attachmentRepository.add(a);
        }

    }

    @Override
    @Transactional
    public void deleteTicket(long id) {
        ticketRepository.deleteById(id);
    }
}
