package org.hashlearning.backend.controller;

import org.hashlearning.backend.model.dto.NotesForAllCourses;
import org.hashlearning.backend.model.dto.NotesRequest;
import org.hashlearning.backend.model.dto.NotesResponse;
import org.hashlearning.backend.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotesController {

    @Autowired
    private NotesService notesService;

    @GetMapping("/api/courses/{courseId}/notes")
    public ResponseEntity<List<NotesForAllCourses>> getNotesByCourseId(@PathVariable int courseId){
        return new ResponseEntity<>(notesService.getAllNotesByCourseId(courseId), HttpStatus.OK);
    }

    @PostMapping("/api/courses/{courseId}/notes")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public ResponseEntity<NotesResponse> addNotes(@RequestBody NotesRequest notesRequest
            , @PathVariable int courseId)
    {
        return new ResponseEntity<>(notesService.addNotes(notesRequest, courseId), HttpStatus.OK);
    }
}
