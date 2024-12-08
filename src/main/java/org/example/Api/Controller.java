package org.example.Api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/hello")
    public String sayHello() {
        return toString();
    }

    @GetMapping("/error")
    public String sayError() {
        return "ACHTUNG!";
    }
}
