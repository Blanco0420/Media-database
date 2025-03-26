package com.media.database.media_database.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.media.database.media_database.enums.AvailableRoles;
import com.media.database.media_database.models.MediaPersonModel;
import com.media.database.media_database.models.dto.MediaPersonDTO;
import com.media.database.media_database.models.joinTables.PersonRoleModel;
import com.media.database.media_database.repositories.PersonRepository;
import com.media.database.media_database.repositories.PersonRoleRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PersonService {
    @Autowired
    private PersonRoleRepository personRoleRepository;

    public MediaPersonDTO getAllPeople() {
        List<PersonRoleModel> personRoles = personRoleRepository.findAll();
        return new MediaPersonDTO(personRoles);
    }

    public MediaPersonDTO getAllByRole(AvailableRoles role) {
        List<PersonRoleModel> personRoles = personRoleRepository.findByRole(role);
        return new MediaPersonDTO(personRoles);
    }

    public MediaPersonDTO getActorById(Long id) {
    PersonRoleModel personRole = personRoleRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("PersonRoleModel not found with ID: " + id));

    return new MediaPersonDTO(personRole);
}

}

