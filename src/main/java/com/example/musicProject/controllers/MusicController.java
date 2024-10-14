package com.example.musicProject.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api")
public class MusicController {
    @RestController
    @RequestMapping("/api")
    public class SongController {

        @GetMapping("/song")
        public ResponseEntity<Resource> getSong() {
            Resource resource = new ClassPathResource("static/song.mp3");
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("audio/mpeg"))
                    .body(resource);
        }
    }
}
