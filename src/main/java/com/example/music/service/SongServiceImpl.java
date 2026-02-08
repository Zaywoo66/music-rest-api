package com.example.music.service;

import com.example.music.dto.SongRequestDTO;
import com.example.music.dto.SongResponseDTO;
import com.example.music.exception.InvalidSongException;
import com.example.music.exception.SongNotFoundException;
import com.example.music.factory.SongFactory;
import com.example.music.model.Song;
import com.example.music.repository.SongRepository;
import com.example.music.util.ReflectionPrinter;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository repository;

    public SongServiceImpl(SongRepository repository) {
        this.repository = repository;
    }

    private void validate(SongRequestDTO dto) {
        if (dto.getTitle() == null || dto.getTitle().isBlank()) {
            throw new InvalidSongException("Song title cannot be empty");
        }
        if (dto.getDuration() <= 0) {
            throw new InvalidSongException("Duration must be positive");
        }
    }

    private SongResponseDTO toDTO(Song song) {
        return new SongResponseDTO(song.getId(), song.getTitle(), song.getDuration());
    }

    @Override
    public SongResponseDTO createSong(SongRequestDTO dto) {
        validate(dto);

        Song song = SongFactory.createSong(dto);


        ReflectionPrinter.printObjectFields(song);

        Song saved = repository.save(song);
        return toDTO(saved);
    }

    @Override
    public List<SongResponseDTO> getAllSongs() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public SongResponseDTO getSongById(Long id) {
        Song song = repository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));

        return toDTO(song);
    }

    @Override
    public SongResponseDTO updateSong(Long id, SongRequestDTO dto) {
        validate(dto);

        Song existing = repository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));

        existing.setTitle(dto.getTitle());
        existing.setDuration(dto.getDuration());

        Song updated = repository.save(existing);
        return toDTO(updated);
    }

    @Override
    public void deleteSong(Long id) {
        Song existing = repository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));

        repository.delete(existing);
    }

    @Override
    public List<SongResponseDTO> getSongsSortedByDuration() {
        return repository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Song::getDuration)) // lambda + method reference
                .map(this::toDTO)
                .toList();
    }
}

