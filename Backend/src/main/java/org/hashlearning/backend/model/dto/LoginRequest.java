package org.hashlearning.backend.model.dto;

public record LoginRequest(
        String email,
        String password
) {
}
