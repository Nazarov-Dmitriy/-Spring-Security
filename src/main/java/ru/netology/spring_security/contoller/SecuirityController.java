package ru.netology.spring_security.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuirityController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/read")
    public String read() {
        return "read";
    }

    @GetMapping("/write")
    public String write() {
        return "write";
    }



}

