package com.wgc.persons.controller.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping(value = "/admin", produces = "application/json;charset=utf-8")
    public String query() {
        return "有权限进入了";
    }
}
