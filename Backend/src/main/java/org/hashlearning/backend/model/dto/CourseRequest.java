package org.hashlearning.backend.model.dto;

import org.hashlearning.backend.model.Notes;
import org.hashlearning.backend.model.Videos;

import java.util.List;

public record CourseRequest(
   String course_name,
   String course_desc,
   int semester
) {
}
