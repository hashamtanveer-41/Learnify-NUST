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
public class Videos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int video_id;
    @ManyToOne
    @JoinColumn(name = "courses_id")
    private Courses course_id;
//    @OneToMany(mappedBy = "video_id")
//    private List<Progress> progress;
    private String title;
    private String youtube_id;
    private int duration;
}
