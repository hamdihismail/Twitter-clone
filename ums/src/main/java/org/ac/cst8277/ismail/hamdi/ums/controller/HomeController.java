package org.ac.cst8277.ismail.hamdi.ums.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String home() {
    	 return "<html><body><h1>Homepage</h1><p>Check the console for your token.</p></body></html>"; 
    }
}