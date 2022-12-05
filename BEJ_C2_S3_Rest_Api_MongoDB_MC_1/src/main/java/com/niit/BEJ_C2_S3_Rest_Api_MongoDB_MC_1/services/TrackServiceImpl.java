/*
 *Author Name: Nikita Chauhan
 *Date: 24-11-2022
 *Created With: IntelliJ IDEA Community Edition
 */


package com.niit.BEJ_C2_S3_Rest_Api_MongoDB_MC_1.services;

import com.niit.BEJ_C2_S3_Rest_Api_MongoDB_MC_1.domain.Track;
import com.niit.BEJ_C2_S3_Rest_Api_MongoDB_MC_1.exception.TrackAlreadyExistsException;
import com.niit.BEJ_C2_S3_Rest_Api_MongoDB_MC_1.exception.TrackDoesNotExistsException;
import com.niit.BEJ_C2_S3_Rest_Api_MongoDB_MC_1.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements ITrackService {

    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrackDetail(Track track) throws TrackAlreadyExistsException {
        if (trackRepository.findById(track.getTrackId()).isPresent()) {
            throw new TrackAlreadyExistsException();
        }
        return trackRepository.save(track);
    }

    @Override
    public boolean deleteTrack(int id) throws TrackDoesNotExistsException {
        boolean flag = false;
        if (trackRepository.findById(id).isEmpty()) {
            throw new TrackDoesNotExistsException();
        } else {
            trackRepository.deleteById(id);
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Track> getAllTrackDetails() throws Exception {
        return trackRepository.findAll();
    }

    @Override
    public List<Track> getAllTrackByArtistName(String artistName) throws TrackDoesNotExistsException {
        if (trackRepository.findAllTrackByArtistName(artistName).isEmpty()) {
            throw new TrackDoesNotExistsException();
        }
        return trackRepository.findAllTrackByArtistName(artistName);
    }

    @Override
    public List<Track> getAllTrackWithGreaterRating(double trackRating) throws TrackDoesNotExistsException {
        if (trackRepository.finAllTrackWithGreaterRating(trackRating).isEmpty()) {
            throw new TrackDoesNotExistsException();
        }
        return trackRepository.finAllTrackWithGreaterRating(trackRating);
    }
}
