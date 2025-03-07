package com.media.database.media_database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import com.media.database.media_database.models.TvShowModel;
import com.media.database.media_database.services.TvShowService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/api/tv")
public class TvShowController {
    @Autowired
    TvShowService tvShowService;

    // @GetMapping("")
    // public String getAllTvShows(Model model) {
    //     model.addAttribute("medias", tvShowService.getAll());
    //     model.addAttribute("type", "tv");
    //     return "mediaList";
    // }

    // @GetMapping("{id}")
    // public String getById(@PathVariable Long id, Model model) {

    //     model.addAttribute("media", tvShowService.getById(id));
    //     return "media";
    // }

    // @GetMapping("{id}")
    // public String getById(@PathVariable Long id, Model model) {

    // model.addAttribute("media", tvShowService.getById(id));
    // return "media";
    // }

    @PostMapping("api/new")
    public ResponseEntity<TvShowModel> createTvShow(@RequestBody TvShowModel tvShowModel) {
        tvShowService.create(tvShowModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(tvShowModel);

    }

}
