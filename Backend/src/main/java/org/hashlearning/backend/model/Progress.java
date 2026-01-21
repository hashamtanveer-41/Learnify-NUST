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
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int progres_id;
    @ManyToMany
    private List<Users> user_id;
    @ManyToMany
    private List<Videos> video_id;
    private String status;
}
