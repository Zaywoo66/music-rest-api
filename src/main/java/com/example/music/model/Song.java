package com.example.music.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int duration;

    public Song() {}

    private Song(Builder builder) {
        this.title = builder.title;
        this.duration = builder.duration;
    }

    // ===== Builder Pattern =====
    public static class Builder {
        private String title;
        private int duration;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public Song build() {
            return new Song(this);
        }
    }

    // ===== Getters / Setters =====
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

    // ===== equals/hashCode/toString =====
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song song)) return false;
        return Objects.equals(id, song.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
