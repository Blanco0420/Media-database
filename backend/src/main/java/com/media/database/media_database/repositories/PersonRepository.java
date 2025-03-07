package com.media.database.media_database.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.media.database.media_database.models.PersonModel;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, Long> {
    Optional<PersonModel> findByFirstNameAndLastName(String firstName, String lastName);
}
