package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/shopping")
public class HomeController {
    @RequestMapping(value = {"", "/", "index"}, method = RequestMethod.GET)
    public String index() {
        return "web/home.zul";
    }
}
