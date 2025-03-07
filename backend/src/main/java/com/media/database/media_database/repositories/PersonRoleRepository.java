package com.media.database.media_database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.media.database.media_database.models.joinTables.PersonRoleModel;

@Repository
public interface PersonRoleRepository extends JpaRepository<PersonRoleModel, Long> {

}
