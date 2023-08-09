package com.example.zoeparrishcustomersupport.site;

import com.example.zoeparrishcustomersupport.entities.UserPrinciple;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.Hashtable;
import java.util.Map;

@Controller
public class LoginController {
    //public static final Map<String,String> userDB = new Hashtable<>();
    //static {
    //   userDB.put("Zoe","Zparrish99");
    //   userDB.put("John","password");
    //   userDB.put("Mitch","Semper Fi");
    //}

    @Inject AuthenticationService authenticationService;

    @GetMapping("login")
    public ModelAndView loginForm(HttpSession session){
        if (UserPrinciple.getPrincipal(session) != null){
            return new ModelAndView(new RedirectView("/ticket/list",true,false));
        }
        return new ModelAndView("login","loginForm", new LoginForm());
    }

    @PostMapping("login")
    public ModelAndView loginCheck( @ModelAttribute("loginForm")LoginForm form, HttpSession session, HttpServletRequest request, Model model){

        if (UserPrinciple.getPrincipal(session) != null){
            return new ModelAndView(new RedirectView("/ticket/list",true,false));
        }

        Principal principal;
        try{
            principal = authenticationService.authenticate(form.getUsername(), form.getPassword());
        }catch (ConstraintViolationException e){
            return new ModelAndView("login");
        }

        if(principal == null){
            form.setPassword(null);
        }
        UserPrinciple.setPrincipal(session,principal);
        request.changeSessionId();
        return new ModelAndView(new RedirectView("/ticket/list",true,false));
    }

    @RequestMapping("logout")
    public View logout(HttpSession session){
        session.invalidate();
        return new RedirectView("login",true,false);
    }

    public static class LoginForm {
        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        private String password;



    }
}
