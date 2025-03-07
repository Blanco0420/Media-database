package com.media.database.media_database.services;

import org.springframework.stereotype.Service;

import com.media.database.media_database.models.AnimeModel;
import com.media.database.media_database.repositories.AnimeRepository;

@Service
public class AnimeService extends MediaService<AnimeModel> {
    public AnimeService(AnimeRepository<AnimeModel> repository) {
        super(repository);
    }
}
