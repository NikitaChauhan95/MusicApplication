/*
 *Author Name: Nikita Chauhan
 *Date: 24-11-2022
 *Created With: IntelliJ IDEA Community Edition
 */


package com.niit.BEJ_C2_S3_Rest_Api_MongoDB_MC_1.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Track {

    @Id
    private int trackId;
    private String trackName;
    private double trackRating;
    private Artist trackArtist;

    private String userName;

    private String password;

    public Track() {
    }

    public Track(int trackId, String trackName, double trackRating, Artist trackArtist, String userName, String password) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.trackRating = trackRating;
        this.trackArtist = trackArtist;
        this.userName = userName;
        this.password = password;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public double getTrackRating() {
        return trackRating;
    }

    public void setTrackRating(double trackRating) {
        this.trackRating = trackRating;
    }

    public Artist getTrackArtist() {
        return trackArtist;
    }

    public void setTrackArtist(Artist trackArtist) {
        this.trackArtist = trackArtist;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackId=" + trackId +
                ", trackName='" + trackName + '\'' +
                ", trackRating=" + trackRating +
                ", trackArtist=" + trackArtist +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
