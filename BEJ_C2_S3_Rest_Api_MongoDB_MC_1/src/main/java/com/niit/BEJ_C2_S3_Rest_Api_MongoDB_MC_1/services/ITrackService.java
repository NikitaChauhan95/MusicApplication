package com.niit.BEJ_C2_S3_Rest_Api_MongoDB_MC_1.services;

import com.niit.BEJ_C2_S3_Rest_Api_MongoDB_MC_1.domain.Track;
import com.niit.BEJ_C2_S3_Rest_Api_MongoDB_MC_1.exception.TrackAlreadyExistsException;
import com.niit.BEJ_C2_S3_Rest_Api_MongoDB_MC_1.exception.TrackDoesNotExistsException;

import java.util.List;

public interface ITrackService {

    Track saveTrackDetail(Track track) throws TrackAlreadyExistsException;

    boolean deleteTrack(int id) throws TrackDoesNotExistsException;

    List<Track> getAllTrackDetails() throws Exception;

    List<Track> getAllTrackByArtistName(String artistName) throws TrackDoesNotExistsException;

    List<Track> getAllTrackWithGreaterRating(double trackRating) throws TrackDoesNotExistsException;
}
