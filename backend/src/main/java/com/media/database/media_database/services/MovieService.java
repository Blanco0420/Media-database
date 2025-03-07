package com.media.database.media_database.services;

import org.springframework.stereotype.Service;

import com.media.database.media_database.models.MovieModel;
import com.media.database.media_database.repositories.MovieRepository;

/**
 * MovieService
 */
@Service
public class MovieService extends MediaService<MovieModel> {
    public MovieService(MovieRepository<MovieModel> repository) {
        super(repository);
    }
}
// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Service;

// import com.media.database.media_database.exceptions.MovieNotFoundException;
// import com.media.database.media_database.models.MovieModel;
// import com.media.database.media_database.models.PersonModel;
// import com.media.database.media_database.repositories.MovieRepository;
// import com.media.database.media_database.repositories.PersonRepository;

// import jakarta.persistence.EntityExistsException;

// @Service
// public class MovieService {
// @Autowired
// private MovieRepository movieRepository;
// @Autowired
// private PersonRepository personRepository;

// public List<MovieModel> getAllMovies() {
// return movieRepository.findAll();

// }

// public MovieModel getMovieById(Long id) {
// return movieRepository.findById(id).orElseThrow(() -> new
// MovieNotFoundException());
// }

// public MovieModel getMovieByName(String name) {

// return movieRepository.findByName(name);
// }

// // TODO: Check if movie is all the same
// public MovieModel createMovie(MovieModel movie) {
// boolean exists = movieRepository.existsByName(movie.getName());
// if (exists) {
// throw new EntityExistsException();
// }
// // else{
// // return movieRepository.save(movie);
// // }
// for (PersonModel actor : movie.getActors()) {
// PersonModel existingActor = personRepository
// .findByFirstNameAndLastName(actor.getFirstName(), actor.getLastName())
// .orElseGet(() -> personRepository.save(actor));
// actor.setId(existingActor.getId());
// }
// for (PersonModel director : movie.getDirectors()) {
// PersonModel existingDirector = personRepository
// .findByFirstNameAndLastName(director.getFirstName(), director.getLastName())
// .orElseGet(() -> personRepository.save(director));
// director.setId(existingDirector.getId());
// }

// return movieRepository.save(movie);

// }

// public Optional<MovieModel> updateMovie(Long id, MovieModel movieModel) {
// return movieRepository.findById(id).map(movie -> {
// movie.setName(movieModel.getName());
// movie.setReleaseDate(movieModel.getReleaseDate());
// movie.setDirector(movieModel.getDirectors());
// movie.setActors(movieModel.getActors());
// movie.setRating(movieModel.getRating());
// return movieRepository.save(movie);
// });
// }

// public ResponseEntity<Void> deleteMovie(Long id) {
// if (movieRepository.existsById(id)) {
// movieRepository.deleteById(id);
// return ResponseEntity.ok().build();
// }
// return ResponseEntity.notFound().build();

// }

// }
