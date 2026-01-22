package org.hashlearning.backend.service;

import org.hashlearning.backend.model.Notes;
import org.hashlearning.backend.model.dto.NotesForAllCourses;
import org.hashlearning.backend.model.dto.NotesRequest;
import org.hashlearning.backend.model.dto.NotesResponse;
import org.hashlearning.backend.repo.CourseRepo;
import org.hashlearning.backend.repo.NotesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotesService {

    @Autowired
    private NotesRepo notesRepo;

    @Autowired
    private CourseRepo courseRepo;


    public List<NotesForAllCourses> getAllNotesByCourseId(int courseId) {
        List<Notes> notes = notesRepo.findNotesByCourseId_CourseId(courseId);
        List<NotesForAllCourses> notesForAllCoursesList = new ArrayList<>();
        for (Notes notes1: notes){
            notesForAllCoursesList.add(new NotesForAllCourses(
                    notes1.getNotes_id(),
                    notes1.getTitle(),
                    notes1.getContent()
            ));
        }
        if (!(notesForAllCoursesList.isEmpty())){
            return notesForAllCoursesList;
        }else {
            return null;
        }
    }

    public NotesResponse addNotes(NotesRequest notesRequest, int courseId) {
        Notes note = new Notes();
        note.setContent(notesRequest.content());
        note.setTitle(notesRequest.title());
        note.setCourseId(courseRepo.findCoursesByCourseId(courseId));
        notesRepo.save(note);
        if (note.getNotes_id()!=0){
            return new NotesResponse(
                    "Notes has been successfully saved.",
                    note.getNotes_id()
            );
        }
        return null;
    }
}
