package com.media.database.media_database.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.media.database.media_database.models.PersonModel;
import com.media.database.media_database.repositories.PersonRepository;

@Controller
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("")
    public @ResponseBody List<PersonModel> getAllPeople() {
        return personRepository.findAll();
    }
}