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
    private int videoId;
    @ManyToOne
    @JoinColumn(name = "courseId")
    private Courses courseId;

    private String title;
    private String youtubeId;
    private int duration;
}
