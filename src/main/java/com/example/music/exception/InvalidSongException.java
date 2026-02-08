package com.example.music.exception;

public class InvalidSongException extends RuntimeException {
    public InvalidSongException(String message) {
        super(message);
    }
}

