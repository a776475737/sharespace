package com.music.sharespace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@RestController
@SpringBootApplication(scanBasePackages={"com.music.sharespace"})
@Configuration
@CrossOrigin(origins="*", maxAge=3600)
public class App extends SpringBootServletInitializer {

    @RequestMapping("/")
    @ResponseBody
    public Message home() {
        return new Message("Hello World");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }

    @GetMapping("/user")
    @ResponseBody
    public Principal user(Principal user) {
        return user;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }

}
