package com.music.sharespace.domain;

import java.io.File;
import java.util.List;

public class TrackInfo {

    private File trackFile;
    private List<String> artists;
    private String song;
    private String album;
    private String genre;
    private String uploader;

    public File getTrackFile() {
        return trackFile;
    }

    public void setTrackFile(File trackFile) {
        this.trackFile = trackFile;
    }

    public List<String> getArtists() {
        return artists;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
}
