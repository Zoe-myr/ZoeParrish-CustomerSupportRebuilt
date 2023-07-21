package com.example.zoeparrishcustomersupport.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.naming.ldap.Control;

@Configuration
@ComponentScan(basePackages = "com.example.zoeparrishcustomersupport.site", excludeFilters = @ComponentScan.Filter(Control.class))
public class RootContextConfig {

}
