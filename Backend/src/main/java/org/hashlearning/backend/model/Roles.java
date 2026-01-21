package org.hashlearning.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Roles {
    @Id
    private int id;
    private String name;
    @OneToMany(mappedBy = "role_id")
    private List<Users> user_id;

}
