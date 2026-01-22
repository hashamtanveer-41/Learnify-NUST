package org.hashlearning.backend.service;

import org.hashlearning.backend.model.Courses;
import org.hashlearning.backend.model.Notes;
import org.hashlearning.backend.model.Videos;
import org.hashlearning.backend.model.dto.CourseRequest;
import org.hashlearning.backend.model.dto.CourseResponse;
import org.hashlearning.backend.model.dto.CourseResponseById;
import org.hashlearning.backend.repo.CourseRepo;
import org.hashlearning.backend.repo.NotesRepo;
import org.hashlearning.backend.repo.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private VideoRepo videoRepo;

    @Autowired
    private NotesRepo notesRepo;

    public List<Courses> getAllCourses() {
        return courseRepo.findAll();
    }

    public CourseResponse addCourse(CourseRequest courseRequest) {

        Courses course = new Courses();
        course.setCourseDesc(courseRequest.course_desc());
        course.setCourseName(courseRequest.course_name());
        course.setSemester(courseRequest.semester());
        courseRepo.save(course);


        if (course.getCourseId()!= 0){
            return  new CourseResponse(
                    "Course added successfully",
                    course.getCourseId()
            );
        }else {
            return null;
        }
    }

    public CourseResponseById getCourseById(int courseId) {
        Courses course = courseRepo.findCoursesByCourseId(courseId);
        if (course.getCourseId()!=0){
            List<Notes> notes = notesRepo.findNotesByCourseId_CourseId(courseId);
            List<Videos> videos1 = videoRepo.findVideosByCourseId_CourseId(courseId);
            CourseResponseById response = new CourseResponseById(
                    course,
                    videos1,
                    notes
            );
            return  response;
        }
        return null;
    }
}
