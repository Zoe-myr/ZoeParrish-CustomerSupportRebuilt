package com.example.zoeparrishcustomersupport.site;

import com.example.zoeparrishcustomersupport.site.Ticket;
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
    private volatile int ticketId = 1;
    private HashMap<Integer, Ticket> ticketDB = new HashMap<>();

    @RequestMapping(value={"list",""})
    public String listTickets(Model model){
        model.addAttribute("ticketDB",ticketDB);
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

        int id;
        synchronized (this){
            id =this.ticketId;
            ticketDB.put(id,ticket);
            ticketId++;
        }

        return new RedirectView("view/"+id,true,false);
    }

    @GetMapping("view/{ticketId}")
    public ModelAndView viewTicket(Model model, @PathVariable("ticketId")int ticketId){
        Ticket ticket = ticketDB.get(ticketId);

        if(ticket==null){
            return new ModelAndView(new RedirectView("listTickets",true,false));
        }

        model.addAttribute("ticketId",ticketId);
        model.addAttribute("ticket",ticket);

        return new ModelAndView("viewTicket");
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
