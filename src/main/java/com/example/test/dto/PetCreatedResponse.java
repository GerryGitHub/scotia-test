package com.example.test.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record PetCreatedResponse(
        UUID transactionId,
        LocalDateTime dateCreated,
        boolean status,
        String name

) {
}
