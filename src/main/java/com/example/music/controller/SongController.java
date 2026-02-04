package com.example.music.controller;

import com.example.music.model.Song;
import com.example.music.service.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    private final SongService service;

    public SongController(SongService service) {
        this.service = service;
    }

    @PostMapping
    public Song add(@RequestBody Song song) {
        return service.save(song);
    }

    @GetMapping
    public List<Song> getAll() {
        return service.findAll();
    }
}

