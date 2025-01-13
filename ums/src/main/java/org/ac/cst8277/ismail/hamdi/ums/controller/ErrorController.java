package org.ac.cst8277.ismail.hamdi.ums.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

    @GetMapping("/403")
    @ResponseBody
    public String accessDenied() {
        return "<html><body><h1>403 Forbidden</h1><p>You do not have permission to access this page.</p></body></html>";
    }
}