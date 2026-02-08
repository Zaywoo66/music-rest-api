package com.example.music.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SongNotFoundException.class)
    public ResponseEntity<?> handleNotFound(SongNotFoundException e) {
        return ResponseEntity.status(404).body(Map.of(
                "error", e.getMessage()
        ));
    }

    @ExceptionHandler(InvalidSongException.class)
    public ResponseEntity<?> handleInvalidSong(InvalidSongException e) {
        return ResponseEntity.status(400).body(Map.of(
                "error", e.getMessage()
        ));
    }
}


