package org.hashlearning.backend.controller;

import org.hashlearning.backend.model.Videos;
import org.hashlearning.backend.model.dto.VideoRequest;
import org.hashlearning.backend.model.dto.VideoResponse;
import org.hashlearning.backend.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VideosController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/api/videos/{videoId}")
    public ResponseEntity<Videos> getVideoById(@PathVariable int videoId){
        return new ResponseEntity<>(videoService.getVideoById(videoId), HttpStatus.OK);
    }

    @PostMapping("/api/videos")
    public ResponseEntity<VideoResponse> addVideo(@RequestBody VideoRequest videoRequest){
        return new ResponseEntity<>(videoService.addVideo(videoRequest), HttpStatus.OK);
    }
}
