package org.hashlearning.backend.repo;

import org.hashlearning.backend.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Courses, Integer > {
    Courses findCoursesByCourseId(int courseId);
}
