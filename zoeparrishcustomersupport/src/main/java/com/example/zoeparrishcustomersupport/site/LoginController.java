package com.example.zoeparrishcustomersupport.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView loginForm(){
        return new ModelAndView("login","loginForm",new  LoginForm());
    }

    public static class LoginForm{
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
