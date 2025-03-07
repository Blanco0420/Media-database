package com.media.database.media_database.repositories;

import org.springframework.stereotype.Repository;

import com.media.database.media_database.models.MediaModel;
import com.media.database.media_database.models.MovieModel;

@Repository
public interface MovieRepository<T extends MediaModel> extends MediaRepository<MovieModel> {
}