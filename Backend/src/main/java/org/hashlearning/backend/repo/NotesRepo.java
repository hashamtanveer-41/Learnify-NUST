package org.hashlearning.backend.repo;

import org.hashlearning.backend.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepo extends JpaRepository<Notes, Integer> {
    List<Notes> findNotesByCourseId_CourseId(int courseIdCourseId);
}
