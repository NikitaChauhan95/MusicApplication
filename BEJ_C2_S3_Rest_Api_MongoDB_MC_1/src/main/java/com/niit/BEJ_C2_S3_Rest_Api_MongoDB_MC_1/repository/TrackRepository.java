package com.niit.BEJ_C2_S3_Rest_Api_MongoDB_MC_1.repository;

import com.niit.BEJ_C2_S3_Rest_Api_MongoDB_MC_1.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends MongoRepository<Track, Integer> {
    //            db.inventory.find( { quantity: { $gt: 20 } } )
    @Query("{trackRating : {$gt : 4 }}")
    List<Track> finAllTrackWithGreaterRating(double trackRating);

    @Query("{'trackArtist.artistName' : {$in : [?0]}}")
    List<Track> findAllTrackByArtistName(String artistName);

}
