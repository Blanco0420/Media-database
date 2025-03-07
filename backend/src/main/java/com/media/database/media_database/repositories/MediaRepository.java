package com.media.database.media_database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.media.database.media_database.models.MediaModel;

@NoRepositoryBean
public interface MediaRepository<T extends MediaModel> extends JpaRepository<T, Long> {
    boolean existsByName(String name);

    T findByName(String name);
}
