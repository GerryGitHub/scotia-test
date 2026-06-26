package com.example.test.dto;

public record PetRequest(
        Long id,
        String name,
        String status
) {
}
