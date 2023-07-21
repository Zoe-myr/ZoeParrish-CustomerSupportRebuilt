package com.example.zoeparrishcustomersupport.site;

import com.example.zoeparrishcustomersupport.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@RequestMapping("ticket")
public class TicketController {
    private volatile int ticketId = 1;
    private HashMap<Integer, Ticket> ticketDB = new HashMap<>();

    @RequestMapping(value={"list",""})
    public String listBlogs(Model model){
        model.addAttribute("ticketDB",ticketDB);
        return "listTickets";
    }

    @GetMapping("create")
    public ModelAndView createTicket() {
       return new ModelAndView("ticketForm", "ticket", new TicketForm());
    }




    public static class TicketForm {
     private String title;
     private String Body;
     private String Subject;
     private MultipartFile attachment;


        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

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
    }
}
