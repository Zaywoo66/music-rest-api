package com.example.music.service;

import com.example.music.dto.SongRequestDTO;
import com.example.music.dto.SongResponseDTO;

import java.util.List;

public interface SongService {

    SongResponseDTO createSong(SongRequestDTO dto);

    List<SongResponseDTO> getAllSongs();

    SongResponseDTO getSongById(Long id);

    SongResponseDTO updateSong(Long id, SongRequestDTO dto);

    void deleteSong(Long id);

    List<SongResponseDTO> getSongsSortedByDuration();
}

