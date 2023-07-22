package com.example.zoeparrishcustomersupport.site;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Hashtable;
import java.util.Map;

@Controller
public class LoginController {
    public static final Map<String,String> userDB = new Hashtable<>();
    static {
        userDB.put("Zoe","Zparrish99");
        userDB.put("John","password");
        userDB.put("Mitch","Semper Fi");
    }

    @GetMapping("login")
    public ModelAndView loginForm(HttpSession session){
        if (session.getAttribute("username") != null){
            return new ModelAndView(new RedirectView("/ticket/list",true,false));
        }
        return new ModelAndView("login","loginForm", new LoginForm());
    }

    @PostMapping("login")
    public ModelAndView loginCheck( @ModelAttribute("loginForm")LoginForm form, HttpSession session, HttpServletRequest request, Model model){

        if (session.getAttribute("username") != null){
            return new ModelAndView(new RedirectView("/ticket/list",true,false));
        }
        String username = form.getUsername();
        String password = form.getPassword();

        if (username == null || password ==null || !userDB.containsKey(username) || !password.equals(userDB.get(username))){
            model.addAttribute("loginFailed",true);
            model.addAttribute("loginForm",form);
            return new ModelAndView("login");
        }else{
            session.setAttribute("username",username);
            request.changeSessionId();
            return new ModelAndView(new RedirectView("/ticket/list",true,false));
        }
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
