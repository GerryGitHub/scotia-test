package com.example.test.entity;

import java.util.List;

public record GetPetApiResponse(
        Long id,
        GetCategoryApiResponse getCategoryApiResponse,
        String name,
        List<String> photoUrls,
        List<GetTagApiResponse> getTagApiResponses,
        String status
) {
}
