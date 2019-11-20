package com.aqzscn.lonely.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dhb")
public class DashboardController {

    @RequestMapping("/info")
    public String info() {
        return "HelloWorld";
    }

}
