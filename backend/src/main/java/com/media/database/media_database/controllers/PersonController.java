package com.media.database.media_database.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.media.database.media_database.exceptions.RoleNotFoundException;
import com.media.database.media_database.enums.AvailableRoles;
import com.media.database.media_database.models.MediaPersonModel;
import com.media.database.media_database.models.dto.MediaPersonDTO;
import com.media.database.media_database.services.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("")
    public ResponseEntity<MediaPersonDTO> getAllPeople(@RequestParam(required = false) String role) {
        if(role != null){
            switch (role) {
                case "actor":
                    return ResponseEntity.ok().body(personService.getAllByRole(AvailableRoles.actor));
                case "director":
                    return ResponseEntity.ok().body(personService.getAllByRole(AvailableRoles.director));
                default:
                    throw new RoleNotFoundException(role);
            }
        }
        return ResponseEntity.ok().body(personService.getAllPeople());
    }
}