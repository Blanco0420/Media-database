package com.media.database.media_database.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.media.database.media_database.exceptions.MediaNotFoundException;
import com.media.database.media_database.exceptions.MediaTypeNotFoundException;
import com.media.database.media_database.models.AnimeModel;
import com.media.database.media_database.models.MediaModel;
import com.media.database.media_database.models.MovieModel;
import com.media.database.media_database.models.TvShowModel;
import com.media.database.media_database.services.AnimeService;
import com.media.database.media_database.services.MediaService;
import com.media.database.media_database.services.MovieService;
import com.media.database.media_database.services.TvShowService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/media")
// @CrossOrigin(origins = "http://localhost:5173")
public class MediaController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private TvShowService tvShowService;
    @Autowired
    private AnimeService animeService;

    private MediaService<?> getServiceType(String type) {
        switch (type.toLowerCase()) {
            case "movie":
                return movieService;
            case "tv":
                return tvShowService;
            case "anime":
                return animeService;
            default:
                throw new MediaTypeNotFoundException(type);
        }
    }

    @GetMapping("{type}")
    public ResponseEntity<List<?>> getAllMedia(@PathVariable String type) {
        MediaService<?> service = getServiceType(type);
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("{type}/{id}")
    public ResponseEntity<?> getMediaById(@PathVariable String type, @PathVariable Long id) {
        MediaService<?> service = getServiceType(type);
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }

    @PostMapping("{type}/new")
    public ResponseEntity<?> createNewMedia(@PathVariable String type, @RequestBody Map<String, Object> mediaModel) {
        return handleMediaOperation(type, mediaModel, false, null);
    }

    @PutMapping("{type}/update/{id}")
    public ResponseEntity<?> updateMedia(@PathVariable String type, @PathVariable Long id,
            @RequestBody Map<String, Object> mediaModel) {
        return handleMediaOperation(type, mediaModel, true, id);
    }

    private ResponseEntity<?> handleMediaOperation(String type, Map<String, Object> mediaModel, boolean isUpdate,
            Long id) {
        ObjectMapper om = new ObjectMapper();

        if ("movie".equalsIgnoreCase(type)) {
            MovieService service = (MovieService) getServiceType(type);
            MovieModel movieModel = om.convertValue(mediaModel, MovieModel.class);
            return isUpdate ? service.update(id, movieModel) : service.create(movieModel);

        } else if ("tv".equalsIgnoreCase(type)) {
            TvShowService service = (TvShowService) getServiceType(type);
            TvShowModel tvShowModel = om.convertValue(mediaModel, TvShowModel.class);
            return isUpdate ? service.update(id, tvShowModel) : service.create(tvShowModel);

        } else if ("anime".equalsIgnoreCase(type)) {
            AnimeService service = (AnimeService) getServiceType(type);
            AnimeModel animeModel = om.convertValue(mediaModel, AnimeModel.class);
            return isUpdate ? service.update(id, animeModel) : service.create(animeModel);
        }

        return ResponseEntity.badRequest().build();
    }

    // @PostMapping("{type}/new")
    // public ResponseEntity<?> createNewMedia(@PathVariable String type,
    // @RequestBody Map<String, Object> mediaModel) {
    // ObjectMapper om = new ObjectMapper();
    // if ("movie".equalsIgnoreCase(type)) {
    // MovieService service = (MovieService) getServiceType(type);
    // MovieModel movieModel = om.convertValue(mediaModel, MovieModel.class);
    // return service.create(movieModel);

    // } else if ("tv".equalsIgnoreCase(type)) {
    // TvShowService service = (TvShowService) getServiceType(type);
    // TvShowModel tvShowModel = om.convertValue(mediaModel, TvShowModel.class);
    // return service.create(tvShowModel);

    // } else if ("anime".equalsIgnoreCase(type)) {

    // AnimeService service = (AnimeService) getServiceType(type);
    // AnimeModel animeModel = om.convertValue(mediaModel, AnimeModel.class);
    // return service.create(animeModel);
    // }
    // return ResponseEntity.badRequest().build();

    // }

    @PostMapping("{type}/{id}/delete")
    public ResponseEntity<Void> removeMediaById(@PathVariable String type, @PathVariable Long id) {
        MediaService<?> service = getServiceType(type);
        return service.deleteMedia(id);
    }

    // @PostMapping("{type}/{id}/update")
    // public String updateMedia(@PathVariable String type, @PathVariable Long id,
    // @RequestBody String entity) {
    // // TODO: process PUT request

    // return entity;
    // }

    // @PostMapping("")
    // public RequestEntity<MediaModel> postMethodName(@RequestParam String type,
    // @RequestBody MediaModel media) {
    // MediaService<?> service = getServiceType(type);
    // service.create(media);

    // }

}