package com.media.database.media_database.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.media.database.media_database.exceptions.MediaNotFoundException;
import com.media.database.media_database.models.MediaModel;
import com.media.database.media_database.models.PersonModel;
import com.media.database.media_database.models.joinTables.PersonRoleModel;
import com.media.database.media_database.repositories.MediaRepository;
import com.media.database.media_database.repositories.PersonRepository;

import jakarta.persistence.EntityExistsException;

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
    public T create(T media) {
        boolean exists = repository.existsByName(media.getName());
        if (exists) {
            throw new EntityExistsException();
        }
        // else{
        // return repository.save(movie);
        // }
        for (PersonRoleModel personRole : media.getPersonRoles()) {
            PersonModel person = personRole.getPerson();
            PersonModel existingPerson = personRepository
                    .findByFirstNameAndLastName(person.getFirstName(), person.getLastName())
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

        return repository.save(media);

    }

    // public T updateMedia(Long id, T mediaModel) {
    // return repository.findById(id).map(media -> {
    // media.setName(mediaModel.getName());
    // media.setReleaseDate(mediaModel.getReleaseDate());
    // media.setPeople(mediaModel.getPeople());
    // media.setRating(mediaModel.getRating());
    // return repository.save(media);
    // })
    // .orElseThrow(() -> new MovieNotFoundException());
    // }

    public ResponseEntity<Void> deleteMedia(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }
}
