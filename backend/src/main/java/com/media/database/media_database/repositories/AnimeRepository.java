package com.media.database.media_database.repositories;

import org.springframework.stereotype.Repository;

import com.media.database.media_database.models.AnimeModel;

@Repository
public interface AnimeRepository<T extends AnimeModel> extends MediaRepository<AnimeModel> {

}