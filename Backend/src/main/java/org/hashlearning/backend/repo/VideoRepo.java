package org.hashlearning.backend.repo;

import org.hashlearning.backend.model.Videos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepo extends JpaRepository<Videos, Integer> {
    List<Videos> findVideosByCourseId_CourseId(int courseIdCourseId);
}
