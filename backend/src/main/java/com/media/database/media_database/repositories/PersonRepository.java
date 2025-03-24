package com.media.database.media_database.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.media.database.media_database.enums.AvailableRoles;
import com.media.database.media_database.models.MediaPersonModel;

@Repository
public interface PersonRepository extends JpaRepository<MediaPersonModel, Long> {
    Optional<MediaPersonModel> findFirstByFirstNameAndLastName(String firstName, String lastName);

    @Query("SELECT p FROM MediaPersonModel p JOIN p.personRoles pr WHERE pr.role = :role")
    List<MediaPersonModel> findByRole(@Param("role") AvailableRoles role);
}
