package org.hashlearning.backend.model.dto;

public record VideoRequest(
        int courseId,
        String title,
        String youtubeId,
        int duration
) {
}
