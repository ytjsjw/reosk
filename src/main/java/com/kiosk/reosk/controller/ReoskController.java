package com.kiosk.reosk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reosk")
public class ReoskController {
    @GetMapping("/")
    public String index() {

        return "/reosk/index";
    }
}
