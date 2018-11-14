package com.rabobank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ksvijaynkl
 * 
 * Main class for booting spring server
 *
 */
@SpringBootApplication
public class SpringBootWebApplication {

    /**
     * Main method - spring boot server
     * @param args
     * @throws Exception     * 
     * 
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }
    
}