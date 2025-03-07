package com.media.database.media_database.services;

import org.springframework.stereotype.Service;

import com.media.database.media_database.models.TvShowModel;
import com.media.database.media_database.repositories.TvShowRepository;

@Service
public class TvShowService extends MediaService<TvShowModel> {
    public TvShowService(TvShowRepository<TvShowModel> repository) {
        super(repository);
    }
}
