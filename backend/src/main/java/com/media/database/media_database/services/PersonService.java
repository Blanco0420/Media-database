package com.media.database.media_database.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.media.database.media_database.enums.AvailableRoles;
import com.media.database.media_database.models.MediaPersonModel;
import com.media.database.media_database.repositories.PersonRepository;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<MediaPersonModel> getAllPeople(){
        return personRepository.findAll();
    }

    public List<MediaPersonModel> getAllByRole(AvailableRoles role) {

        return personRepository.findByRole(role);
    }

    public Optional<MediaPersonModel> getActorById(Long id) {
        return personRepository.findById(id);
    }
}
