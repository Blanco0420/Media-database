package com.media.database.media_database.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.media.database.media_database.models.MediaPersonModel;

@Repository
public interface PersonRepository extends JpaRepository<MediaPersonModel, Long> {
    Optional<MediaPersonModel> findFirstByFirstNameAndLastName(String firstName, String lastName);
}
