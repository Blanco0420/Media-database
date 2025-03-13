
package com.media.database.media_database.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.media.database.media_database.models.joinTables.PersonRoleModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class MediaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Date releaseDate;
    private double rating;

    @OneToMany(mappedBy = "media", cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JsonManagedReference
    private Set<PersonRoleModel> personRoles = new HashSet<>();

    // @ManyToMany
    // @JoinTable(name = "media_people", joinColumns = @JoinColumn(name =
    // "media_id"), inverseJoinColumns = @JoinColumn(name = "person_id"))
    // private Set<PersonModel> people = new HashSet<>();

    private enum watchStatuses {
        wantToWatch,
        watching,
        watched
    }

    private watchStatuses watchStatus = watchStatuses.wantToWatch;

    private boolean airingStatus;

    private Set<String> genres = new HashSet<>();

    // private List<PersonModel> actors;
    // @OneToMany(cascade = CascadeType.ALL)
    // private List<PersonModel> directors;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Set<PersonRoleModel> getPersonRoles() {
        return personRoles;
    }

    public void setPersonRoles(Set<PersonRoleModel> personRoles) {
        this.personRoles = personRoles;
    }

    public watchStatuses getWatchStatus() {
        return watchStatus;
    }

    public void setWatchStatus(watchStatuses watchStatus) {
        this.watchStatus = watchStatus;
    }

    public boolean getAiringStatus() {
        return airingStatus;
    }

    public void setAiringStatus(boolean airingStatus) {
        this.airingStatus = airingStatus;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public void setGenres(Set<String> genres) {
        this.genres = genres;
    }
}