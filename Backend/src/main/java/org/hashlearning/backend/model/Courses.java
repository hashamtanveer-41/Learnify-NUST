package org.hashlearning.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courses_id;
    private String course_name;
    private String course_desc;
    private int semester;
    @OneToMany(mappedBy = "course_id")
    private List<Videos> videos;
    @OneToMany(mappedBy = "course_id")
    private List<Notes> notes;
}
