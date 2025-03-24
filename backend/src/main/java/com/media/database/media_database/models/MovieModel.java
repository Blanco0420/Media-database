package com.media.database.media_database.models;



// import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;

@Entity
public class MovieModel extends MediaModel {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long id;
    // private String name;
    // // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    // @DateTimeFormat(pattern = "yyyy-MM-dd")
    // private LocalDate releaseDate;
    // private double rating;

    // @ManyToMany()
    // @JoinTable(name = "movie_actor", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "personId"))
    // private Set<PersonModel> actors = new HashSet<>();

    // @ManyToMany()
    // @JoinTable(name = "movie_director", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "personId"))
    // private Set<PersonModel> directors = new HashSet<>();
    // // @OneToMany(cascade = CascadeType.ALL)
    // // private List<PersonModel> actors;
    // // @OneToMany(cascade = CascadeType.ALL)
    // // private List<PersonModel> directors;

    // public Set<PersonModel> getActors() {
    //     return actors;
    // }

    // public void setActors(Set<PersonModel> actors) {
    //     this.actors = actors;
    // }

    // public Set<PersonModel> getDirectors() {
    //     return directors;
    // }

    // public void setDirector(Set<PersonModel> director) {
    //     this.directors = director;
    // }
}
