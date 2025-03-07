package com.media.database.media_database.exceptions;

public class MediaNotFoundException extends RuntimeException {
    public MediaNotFoundException(Long id) {
        super("media with id: " + "'" + id + "'" + " Not found");
    }
}
