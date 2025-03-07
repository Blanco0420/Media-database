package com.media.database.media_database.repositories;

import org.springframework.stereotype.Repository;

import com.media.database.media_database.models.MediaModel;
import com.media.database.media_database.models.TvShowModel;

@Repository
public interface TvShowRepository<T extends MediaModel> extends MediaRepository<TvShowModel> {

}