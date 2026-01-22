package org.hashlearning.backend.controller;

import org.hashlearning.backend.model.Courses;
import org.hashlearning.backend.model.dto.CourseRequest;
import org.hashlearning.backend.model.dto.CourseResponse;
import org.hashlearning.backend.model.dto.CourseResponseById;
import org.hashlearning.backend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<List<Courses>> getAllCourses(){
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @PostMapping("/course")
    public ResponseEntity<CourseResponse> addCourse(@RequestBody CourseRequest courseRequest){
        return new ResponseEntity<>(courseService.addCourse(courseRequest), HttpStatus.OK );
    }
    @GetMapping("/courses/{courseId}")
    public ResponseEntity<CourseResponseById> getCourseById(@PathVariable int courseId){
        return new ResponseEntity<>(courseService.getCourseById(courseId), HttpStatus.OK);
    }


}
