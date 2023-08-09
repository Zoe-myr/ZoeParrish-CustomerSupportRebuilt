package com.example.zoeparrishcustomersupport.site;

import com.example.zoeparrishcustomersupport.entities.UserPrinciple;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipal;
import java.security.Principal;

@WebFilter(value = {"/","/ticket/*","/sessions"})
public class AthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)servletRequest).getSession(false);


        final Principal principal = UserPrinciple.getPrincipal(session);

        if(principal == null){
            ((HttpServletResponse)servletResponse).sendRedirect(((HttpServletRequest)servletRequest).getContextPath() + "/login");
        }
        else{
            filterChain.doFilter( new HttpServletRequestWrapper((HttpServletRequest) servletRequest){
                @Override
                public Principal getUserPrincipal(){
                    return principal;}
                },servletResponse);


        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
