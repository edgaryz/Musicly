package com.example.musicProject.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api")
public class MusicController {
    @RestController
    @RequestMapping("/api")
    public static class SongController {
        @GetMapping("/song/{filename}")
        public ResponseEntity<Resource> getSong(@PathVariable String filename) {

            Path currentPath = Paths.get(System.getProperty("user.dir"));
            Path filePath = Paths.get(currentPath.toString(), "song", filename);
            Resource resource = new FileSystemResource(filePath);
            System.out.println();
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("audio/mpeg"))
                    .body(resource);
        }
    }
}
