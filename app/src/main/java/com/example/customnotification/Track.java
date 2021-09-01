package com.example.customnotification;

public class Track {
    private String title;
    private int image;
    private String artist;

    public Track(String title, int image, String artist) {
        this.title = title;
        this.image = image;
        this.artist = artist;
    }

    public Track() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
