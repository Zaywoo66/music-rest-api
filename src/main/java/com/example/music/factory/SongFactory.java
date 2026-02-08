package com.example.music.factory;

import com.example.music.dto.SongRequestDTO;
import com.example.music.model.Song;

public class SongFactory {

    public static Song createSong(SongRequestDTO dto) {
        return new Song.Builder()
                .title(dto.getTitle())
                .duration(dto.getDuration())
                .build();
    }
}

