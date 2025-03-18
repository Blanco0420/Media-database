package com.media.database.media_database.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.media.database.media_database.models.MediaPersonModel;
import com.media.database.media_database.repositories.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("")
    public @ResponseBody List<MediaPersonModel> getAllPeople() {
        System.out.println("GOT HERE");
        
        return personRepository.findAll();
    }
}