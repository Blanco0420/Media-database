package com.media.database.media_database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.media.database.media_database.services.MovieService;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    // private String formatDate(Date date) {
    // DateTimeFormatter d = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    // }

    @GetMapping("")
    public String getAllMovies(Model model) {
        model.addAttribute("medias", movieService.getAll());
        model.addAttribute("type", "movies");
        return "mediaList";
    }

    // @GetMapping("")
    // public String getAllMovies(Model model) {
    // model.
    //
    @GetMapping("{id}")
    public String getMovieById(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.getById(id));
        return "movie";
    }

    // @GetMapping("by-name/{name}")
    // public ResponseEntity<MovieModel> getMovieByName(@PathVariable String
    // name) {
    // MovieModel movie = movieService.getMovieByName(name);
    // if (movie == null) {

    // return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    // }
    // return
    //
    // ResponseEntity.status(HttpStatus.OK).body(movieService.getMovieByName(name));
    // }

    // @GetMapping("new")
    // public String createMovieGet(Model model) {
    // model.addAttribute("movie", new MovieModel());
    // model.addAttribute("actors", personService.getAllActors());
    // return "addMedia";
    // }

    // @PostMapping("new")
    // public String createMoviePost(@ModelAttribute MovieModel movieModel,
    // @RequestParam("actorIds") List<Long> actorIds) {
    // Set<PersonModel> selectedActors = new
    // HashSet<>(personService.getAllActors());
    // movieModel.setActors(selectedActors);
    // movieService.create(movieModel);
    // return "redirect:/movies/" + movieModel.getId();
    // // try {
    // // movieService.createMovie(movie);
    // // return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    // // } catch (EntityExistsException entityExistsException) {
    // // return
    // //
    // //
    // ResponseEntity.status(HttpStatus.CONFLICT).body(movieService.getMovieByName(movie.getName()));
    // // }
    // }

    // FIXME: Make into API? Or a form that fills out info then you can edit
    // @PutMapping("{id}")
    // public ResponseEntity<MovieModel> updateMovie(@PathVariable Long id,
    // @RequestBody MovieModel movieModel) {
    // movieService.updateMedia(id, movieModel);
    // return ResponseEntity.status(HttpStatus.ACCEPTED).body(movieModel);
    // }
}
