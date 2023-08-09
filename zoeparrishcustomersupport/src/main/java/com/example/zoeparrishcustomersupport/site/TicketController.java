package com.example.zoeparrishcustomersupport.site;

import com.example.zoeparrishcustomersupport.entities.Attachment;
import jakarta.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("ticket")
public class TicketController {
    //private volatile int ticketId = 1;
    //private HashMap<Integer, Ticket> ticketDB = new HashMap<>();

    @Inject TicketService ticketService;

    @RequestMapping(value={"list",""})
    public String listTickets(Model model){
        model.addAttribute("ticketDB",ticketService.getAllTickets());
        return "listTickets";
    }

    @GetMapping("create")
    public ModelAndView createTicket() {
       return new ModelAndView("ticketForm", "ticket", new TicketForm());
    }

    @PostMapping("create")
    public View createTicket(@ModelAttribute("ticket") TicketForm form) throws IOException{
       Ticket ticket = new Ticket();
       ticket.setBody(form.getBody());
       ticket.setCustomerName(form.getName());
       ticket.setSubject(form.getSubject());

       MultipartFile file = form.getAttachment();
       Attachment attachment = new Attachment();
       attachment.setName(file.getOriginalFilename());
       attachment.setContents(file.getBytes());
       if(attachment.getName() != null && attachment.getContents().length > 0){
           ticket.addAttachment(attachment);
       }


       ticketService.save(ticket);
        return new RedirectView("view/"+ticket.getId(),true,false);
    }

    @GetMapping("view/{ticketId}")
    public ModelAndView viewTicket(Model model, @PathVariable("ticketId")int ticketId){
        Ticket ticket = ticketService.getTicket(ticketId);

        if(ticket==null){
            return new ModelAndView(new RedirectView("ticket/list",true,false));
        }

        model.addAttribute("ticketId",ticketId);
        model.addAttribute("ticket",ticket);

        return new ModelAndView("viewTicket");
    }

    @GetMapping("/{ticketId}/attachment/{attachment:.+}")
    public View downloadTicket(@PathVariable("ticketId")int ticketId, @PathVariable("attachment")String name){
        Ticket ticket = ticketService.getTicket(ticketId);

        if(ticket == null){
            return new RedirectView("listTickets",true,false);
        }


        Attachment attachment = ticket.getAttachment(0);
        if(attachment == null){
            return new RedirectView("listTickets",true,false);
        }

        return new DownloadView(attachment.getName(),attachment.getContents());
    }


    public static class TicketForm {
     private String name;
     private String Body;
     private String Subject;
     private MultipartFile attachment;



        public String getBody() {
            return Body;
        }

        public void setBody(String body) {
            Body = body;
        }

        public String getSubject() {
            return Subject;
        }

        public void setSubject(String subject) {
            Subject = subject;
        }

        public MultipartFile getAttachment() {
            return attachment;
        }

        public void setAttachment(MultipartFile attachment) {
            this.attachment = attachment;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
