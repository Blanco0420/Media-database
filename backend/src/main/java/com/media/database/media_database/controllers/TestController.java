
package com.media.database.media_database.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("")
    public ResponseEntity<String> getTest() {
        return ResponseEntity.ok().body("Testing");
    }
    
    
}