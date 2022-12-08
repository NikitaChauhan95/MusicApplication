package com.niit.BEJ_C2_S3_Rest_Api_MongoDB_MC_1.proxy;

import com.niit.BEJ_C2_S3_Rest_Api_MongoDB_MC_1.domain.Track;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.PostConstruct;

@FeignClient(name="authentication-service", url = "authentication-service:8084")
public interface TrackProxy {
    @PostMapping("api/v2/register")
    public ResponseEntity<?> register(@RequestBody Track track);
}
