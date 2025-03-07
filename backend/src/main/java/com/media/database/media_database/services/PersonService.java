package com.media.database.media_database.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.media.database.media_database.models.PersonModel;
import com.media.database.media_database.repositories.PersonRepository;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<PersonModel> getAllActors() {

        return personRepository.findAll();
    }

    public List<PersonModel> getAllActorsById(List<Long> ids) {
        return personRepository.findAllById(ids);
    }
}
