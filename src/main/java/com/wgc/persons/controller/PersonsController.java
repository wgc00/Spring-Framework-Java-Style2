package com.wgc.persons.controller;

import com.wgc.persons.entity.Persons;
import com.wgc.persons.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class PersonsController {
    @Autowired
    private PersonsService service;

    @GetMapping
    public List<Persons> selectAll() {
        return service.all();
    }
}
