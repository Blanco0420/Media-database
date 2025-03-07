package com.media.database.media_database.models;

import java.util.ArrayList;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.media.database.media_database.models.joinTables.PersonRoleModel;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date dob;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonRoleModel> personRoles = new ArrayList<>();

    // @ManyToMany
    // @JoinTable(name = "person_roles", joinColumns = @JoinColumn(name =
    // "person_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    // private Set
    // @ElementCollection(targetClass = Role.class)
    // @Enumerated(EnumType.STRING)
    // @CollectionTable(name = "person_roles", joinColumns = @JoinColumn(name =
    // "person_id"))
    // private Set<Role> roles = new HashSet<>();

    // @ManyToMany(mappedBy = "actors")
    // private Set<MovieModel> actedMovies = new HashSet<>();

    // @ManyToMany(mappedBy = "directors")
    // private Set<MovieModel> directedMovies = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

}
