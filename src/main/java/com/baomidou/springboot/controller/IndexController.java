package com.baomidou.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping(value= {"/vm"} )
    public String news(){
        return "news";
    }
}
