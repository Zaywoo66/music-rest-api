package com.example.music.service;

import com.example.music.model.Song;
import com.example.music.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    private final SongRepository repository;

    public SongService(SongRepository repository) {
        this.repository = repository;
    }

    public Song save(Song song) {
        return repository.save(song);
    }

    public List<Song> findAll() {
        return repository.findAll();
    }
}

