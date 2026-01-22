package org.hashlearning.backend.model.dto;

import org.hashlearning.backend.model.Courses;
import org.hashlearning.backend.model.Notes;
import org.hashlearning.backend.model.Videos;

import java.util.List;

public record CourseResponseById(Courses course,
                                 List<Videos> videos,
                                 List<Notes> notes) {
}
