package com.media.database.media_database.models.joinTables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.media.database.enums.Role;
import com.media.database.media_database.models.MediaModel;
import com.media.database.media_database.models.PersonModel;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PersonRoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonModel person;

    @ManyToOne
    @JoinColumn(name = "media_id")
    @JsonBackReference
    private MediaModel media;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Long getId() {
        return id;
    }

    public PersonModel getPerson() {
        return person;
    }

    public void setPerson(PersonModel person) {
        this.person = person;
    }

    public MediaModel getMedia() {
        return media;
    }

    public void setMedia(MediaModel media) {
        this.media = media;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
