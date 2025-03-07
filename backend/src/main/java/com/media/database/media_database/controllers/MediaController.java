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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/media")
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

    // @GetMapping("")
    // public String getHome() {
    // return "addMedia";
    // }

    @GetMapping("{type}")
    public ResponseEntity<List<?>> getAllMedia(@PathVariable String type) {
        MediaService<?> service = getServiceType(type);
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
        // model.addAttribute("medias", service.getAll());
        // model.addAttribute("type", type);
    }

    @GetMapping("{type}/{id}")
    public ResponseEntity<?> getMediaById(@PathVariable String type, @PathVariable Long id) {
        MediaService<?> service = getServiceType(type);
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
        // model.addAttribute("type", type);
        // model.addAttribute("media", service.getById(id));
        // return "media";
    }

    @PostMapping("{type}/new")
    public ResponseEntity<?> createNewMedia(@PathVariable String type, @RequestBody Map<String, Object> mediaModel) {
        ObjectMapper om = new ObjectMapper();
        if ("movie".equalsIgnoreCase(type)) {
            MovieService service = (MovieService) getServiceType(type);
            MovieModel movieModel = om.convertValue(mediaModel, MovieModel.class);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.create(movieModel));
        } else if ("tv".equalsIgnoreCase(type)) {
            TvShowService service = (TvShowService) getServiceType(type);
            TvShowModel tvShowModel = om.convertValue(mediaModel, TvShowModel.class);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.create(tvShowModel));
        } else if ("anime".equalsIgnoreCase(type)) {
            AnimeService service = (AnimeService) getServiceType(type);
            AnimeModel animeModel = om.convertValue(mediaModel, AnimeModel.class);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.create(animeModel));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("{type}/{id}/delete")
    public ResponseEntity<Void> removeMediaById(@PathVariable String type, @PathVariable Long id) {
        MediaService<?> service = getServiceType(type);
        return service.deleteMedia(id);
    }

    // @PostMapping("")
    // public RequestEntity<MediaModel> postMethodName(@RequestParam String type,
    // @RequestBody MediaModel media) {
    // MediaService<?> service = getServiceType(type);
    // service.create(media);

    // }

}