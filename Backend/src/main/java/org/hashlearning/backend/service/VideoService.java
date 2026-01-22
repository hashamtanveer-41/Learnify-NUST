package org.hashlearning.backend.service;

import org.hashlearning.backend.model.Videos;
import org.hashlearning.backend.model.dto.VideoRequest;
import org.hashlearning.backend.model.dto.VideoResponse;
import org.hashlearning.backend.repo.CourseRepo;
import org.hashlearning.backend.repo.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    @Autowired
    private VideoRepo videoRepo;

    @Autowired
    private CourseRepo courseRepo;

    public Videos getVideoById(int videoId) {
          return videoRepo.findVideosByVideoId(videoId);
    }

    public VideoResponse addVideo(VideoRequest videoRequest) {
        Videos video= new Videos();
        video.setDuration(videoRequest.duration());
        video.setTitle(videoRequest.title());
        video.setCourseId(courseRepo.findCoursesByCourseId(videoRequest.courseId()));
        video.setYoutubeId(videoRequest.youtubeId());
        videoRepo.save(video);
        if (video.getVideoId()!= 0){
            return new VideoResponse(
                    "Video added successfully",
                    video.getVideoId()
            );
        }
        return null;
    }
}
