package com.media.database.media_database.exceptions;

public class RoleNotFoundException extends RuntimeException{
    public RoleNotFoundException(String role){
        super("Role type: " + role + " Not found");
    }
    
}