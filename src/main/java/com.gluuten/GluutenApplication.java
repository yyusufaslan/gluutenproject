package com.gluuten;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GluutenApplication  {
    private static final Logger logger = LoggerFactory.getLogger(GluutenApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GluutenApplication.class, args);
    }


}
