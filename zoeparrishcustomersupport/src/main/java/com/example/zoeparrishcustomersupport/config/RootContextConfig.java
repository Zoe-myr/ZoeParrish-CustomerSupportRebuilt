package com.example.zoeparrishcustomersupport.config;

import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import org.hibernate.dialect.MySQL8Dialect;
import org.hibernate.dialect.MySQLDialect;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Hashtable;
import java.util.Map;


@Configuration
@EnableTransactionManagement(mode = AdviceMode.PROXY)
@ComponentScan(basePackages = "com.example.zoeparrishcustomersupport.site", excludeFilters = @ComponentScan.Filter(Controller.class))
public class RootContextConfig  implements TransactionManagementConfigurer {

    @Bean
    public static DataSource dataSource(){
        DriverManagerDataSource dataSource =  new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("ticketApp");
        dataSource.setPassword("Password1!");
        dataSource.setUrl("jdbc:mysql://localhost:3306/customersupport");


        return dataSource;
    }

    @Bean
    public static LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        Map<String, Object> properties =  new Hashtable<>();
        properties.put("jakarta.persistence.schema-generation.database.action","none");

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource());
        factory.setPackagesToScan("com.example.zoeparrishcustomersupport.entities");

        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        factory.setJpaVendorAdapter(adapter);
        factory.setJpaPropertyMap(properties);
        factory.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
        factory.setValidationMode(ValidationMode.NONE);

        return factory;
    }


    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    @Override
    public TransactionManager annotationDrivenTransactionManager() {
        return this.transactionManager();
    }
}
