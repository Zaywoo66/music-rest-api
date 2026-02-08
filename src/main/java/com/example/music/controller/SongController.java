package com.example.music.controller;

import com.example.music.dto.SongRequestDTO;
import com.example.music.dto.SongResponseDTO;
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

    @GetMapping
    public List<SongResponseDTO> getAllSongs() {
        return service.getAllSongs();
    }

    @GetMapping("/{id}")
    public SongResponseDTO getSongById(@PathVariable Long id) {
        return service.getSongById(id);
    }

    @PostMapping
    public SongResponseDTO createSong(@RequestBody SongRequestDTO dto) {
        return service.createSong(dto);
    }

    @PutMapping("/{id}")
    public SongResponseDTO updateSong(@PathVariable Long id,
                                      @RequestBody SongRequestDTO dto) {
        return service.updateSong(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteSong(@PathVariable Long id) {
        service.deleteSong(id);
        return "Deleted song with id = " + id;
    }

    // extra endpoint: sorting feature
    @GetMapping("/sorted")
    public List<SongResponseDTO> getSortedSongs() {
        return service.getSongsSortedByDuration();
    }
}


