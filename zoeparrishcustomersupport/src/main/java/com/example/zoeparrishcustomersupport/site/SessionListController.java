package com.example.zoeparrishcustomersupport.site;


import com.example.zoeparrishcustomersupport.SessionListUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionListController {

    @RequestMapping("sessions")
    public String listSessions(Model model){
        model.addAttribute("numSessions", SessionListUtility.getNumberOfSessions());
        model.addAttribute("sessionList", SessionListUtility.getAllSessions());
        return "sessions";
    }
}
