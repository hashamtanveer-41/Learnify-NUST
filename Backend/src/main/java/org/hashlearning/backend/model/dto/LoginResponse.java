package org.hashlearning.backend.model.dto;

import org.hashlearning.backend.model.Users;

public record LoginResponse(
        String jwtToken,
        Users users
) {
}
