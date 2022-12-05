/*
 *Author Name: Nikita Chauhan
 *Date: 24-11-2022
 *Created With: IntelliJ IDEA Community Edition
 */


package com.niit.BEJ_C2_S3_Rest_Api_MongoDB_MC_1.controller;


import com.niit.BEJ_C2_S3_Rest_Api_MongoDB_MC_1.domain.Track;
import com.niit.BEJ_C2_S3_Rest_Api_MongoDB_MC_1.exception.TrackAlreadyExistsException;
import com.niit.BEJ_C2_S3_Rest_Api_MongoDB_MC_1.exception.TrackDoesNotExistsException;
import com.niit.BEJ_C2_S3_Rest_Api_MongoDB_MC_1.services.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class TrackController {

    private ITrackService iTrackService;

    @Autowired
    public TrackController(ITrackService iTrackService) {
        this.iTrackService = iTrackService;
    }


    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException {
        try {
            return new ResponseEntity<>(iTrackService.saveTrackDetail(track), HttpStatus.CREATED);
        } catch (TrackAlreadyExistsException e) {
            throw new TrackAlreadyExistsException();

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("track/{trackId}")
    public ResponseEntity<?> deleteTrack(@PathVariable("trackId") int trackId) throws TrackDoesNotExistsException {

        try {
            iTrackService.deleteTrack(trackId);
            return new ResponseEntity("Successfully deleted !!!", HttpStatus.OK);
        } catch (TrackDoesNotExistsException e) {
            throw new TrackDoesNotExistsException();
        } catch (Exception exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks() {
        try {
            return new ResponseEntity(iTrackService.getAllTrackDetails(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("tracks/artistName/{artistName}")
    public ResponseEntity<?> getAllTracksByArtistName(@PathVariable String artistName) {

        try {
            return new ResponseEntity(iTrackService.getAllTrackByArtistName(artistName), HttpStatus.OK);

        } catch (Exception exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("tracks/{trackRating}")
    public ResponseEntity<?> getAllTracksByGreaterRating(@PathVariable double trackRating) {

        try {
            return new ResponseEntity(iTrackService.getAllTrackWithGreaterRating(trackRating), HttpStatus.OK);

        } catch (Exception exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
