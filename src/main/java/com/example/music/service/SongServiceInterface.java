package com.example.music.service;

import com.example.music.model.Song;

import java.util.List;

public interface SongServiceInterface {
    Song save(Song song);
    List<Song> findAll();
    Song findById(Long id);
    Song update(Long id, Song song);
    void delete(Long id);
}

