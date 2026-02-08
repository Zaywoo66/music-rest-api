package com.example.music.dto;

public class SongResponseDTO {

    private Long id;
    private String title;
    private int duration;

    public SongResponseDTO() {}

    public SongResponseDTO(Long id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

