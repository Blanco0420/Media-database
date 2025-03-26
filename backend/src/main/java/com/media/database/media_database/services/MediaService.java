package com.media.database.media_database.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.media.database.media_database.exceptions.MediaNotFoundException;
import com.media.database.media_database.models.MediaModel;
import com.media.database.media_database.models.MediaPersonModel;
import com.media.database.media_database.models.joinTables.PersonRoleModel;
import com.media.database.media_database.repositories.MediaRepository;
import com.media.database.media_database.repositories.PersonRepository;


public class MediaService<T extends MediaModel> {
    private final MediaRepository<T> repository;
    @Autowired
    private PersonRepository personRepository;

    public MediaService(MediaRepository<T> repository) {
        this.repository = repository;

    }

    public List<T> getAll() {
        return repository.findAll();

    }

    public T getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new MediaNotFoundException(id));
    }

    public T getByName(String name) {

        return repository.findByName(name);
    }

    // TODO: Check if movie is all the same
    public ResponseEntity<T> create(T media) {
        boolean exists = repository.existsByName(media.getName());
        if (exists) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        // else{
        // return repository.save(movie);
        // }
        for (PersonRoleModel personRole : media.getPersonRoles()) {
            MediaPersonModel person = personRole.getPerson();
            MediaPersonModel existingPerson = personRepository
                    .findFirstByFirstNameAndLastName(person.getFirstName(), person.getLastName())
                    .orElseGet(() -> personRepository.save(person));
            // person.setId(existingPerson.getId());
            personRole.setPerson(existingPerson);
            personRole.setMedia(media);
            // personRole.setPerson(existingPerson);
        }
        // for (PersonModel director : media.getPeople()) {
        // PersonModel existingDirector = personRepository
        // .findByFirstNameAndLastName(director.getFirstName(), director.getLastName())
        // .orElseGet(() -> personRepository.save(director));
        // director.setId(existingDirector.getId());
        // }

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(media));

    }

    public ResponseEntity<T> update(Long id, T mediaModel) {
        return repository.findById(id).map(media -> {
            media.setName(mediaModel.getName());
            media.setReleaseDate(mediaModel.getReleaseDate());
            media.setRating(mediaModel.getRating());

            media.getPersonRoles().clear();
            for (PersonRoleModel personRole : mediaModel.getPersonRoles()) {
                MediaPersonModel person = personRole.getPerson();
                MediaPersonModel existingPerson = personRepository
                        .findFirstByFirstNameAndLastName(person.getFirstName(), person.getLastName())
                        .orElseGet(() -> personRepository.save(person));

                personRole.setPerson(existingPerson);
                personRole.setMedia(media);
                media.getPersonRoles().add(personRole);
            }

            return ResponseEntity.ok(repository.save(media));
        }).orElseThrow(() -> new MediaNotFoundException(id));
    }

    public ResponseEntity<Void> deleteMedia(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }
}
