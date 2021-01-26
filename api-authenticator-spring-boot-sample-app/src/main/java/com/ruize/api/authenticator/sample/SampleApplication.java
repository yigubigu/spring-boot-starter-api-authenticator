package com.ruize.api.authenticator.sample;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SampleApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext appContext;

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String[] beanDefinitionNames = appContext.getBeanDefinitionNames();
        Arrays.sort(beanDefinitionNames);
        for(String bean : beanDefinitionNames) {
            System.out.println(bean);
        }
    }
}
