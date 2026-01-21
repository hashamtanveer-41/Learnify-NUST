package org.hashlearning.backend.model.dto;

public record UsersRequest(String name,
                           String email,
                           String password,
                           int role_id) {


}
