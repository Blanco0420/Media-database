package com.media.database.media_database.models.joinTables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.media.database.media_database.enums.AvailableRoles;
import com.media.database.media_database.models.MediaModel;
import com.media.database.media_database.models.MediaPersonModel;

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
    private MediaPersonModel person;

    @ManyToOne
    @JoinColumn(name = "media_id")
    @JsonBackReference
    private MediaModel media;

    @Enumerated(EnumType.STRING)
    private AvailableRoles role;

    public Long getId() {
        return id;
    }

    public MediaPersonModel getPerson() {
        return person;
    }

    public void setPerson(MediaPersonModel person) {
        this.person = person;
    }

    public MediaModel getMedia() {
        return media;
    }

    public void setMedia(MediaModel media) {
        this.media = media;
    }

    public AvailableRoles getRole() {
        return role;
    }

    public void setRole(AvailableRoles role) {
        this.role = role;
    }
}
