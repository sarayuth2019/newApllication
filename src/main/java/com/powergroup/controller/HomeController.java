package com.powergroup.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//อย่าลบ เอาไว้ตอน deploy
@RestController
@RequestMapping("/home")
public class HomeController {

  @GetMapping("/index")
  public String hello() {
    return "Hello world";
  }

}
