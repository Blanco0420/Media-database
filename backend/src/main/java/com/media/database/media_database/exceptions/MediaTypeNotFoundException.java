package com.media.database.media_database.exceptions;

public class MediaTypeNotFoundException extends RuntimeException {
    public MediaTypeNotFoundException(String mediaType) {
        super("Media type: " + "'" + mediaType + "'" + " Not found");
    }
}