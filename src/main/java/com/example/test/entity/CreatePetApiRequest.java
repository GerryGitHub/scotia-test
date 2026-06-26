package com.example.test.entity;

public record CreatePetApiRequest(
        Long id,
        String name,
        String status
) {
}
