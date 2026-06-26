package com.example.test.entity;

import java.util.List;

public record CreatePetApiResponse(
        Long id,
        CreatePetApiResponse categoryApiResponse,
        String name,
        List<String> photoUrls,
        List<CreateTagApiResponse> tagApiResponses,
        String status
) {
}
