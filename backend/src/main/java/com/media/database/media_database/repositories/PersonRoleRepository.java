package com.media.database.media_database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.media.database.media_database.enums.AvailableRoles;
import com.media.database.media_database.models.MediaPersonModel;
import com.media.database.media_database.models.joinTables.PersonRoleModel;

@Repository
public interface PersonRoleRepository extends JpaRepository<PersonRoleModel, Long> {
    @Query("SELECT pr FROM PersonRoleModel pr WHERE pr.role = :role")
        List<PersonRoleModel> findByRole(@Param("role") AvailableRoles role);
}
