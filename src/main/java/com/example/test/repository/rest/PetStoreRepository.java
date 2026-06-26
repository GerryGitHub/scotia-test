package com.example.test.repository.rest;

import com.example.test.entity.CreatePetApiRequest;
import com.example.test.entity.CreatePetApiResponse;
import com.example.test.entity.GetPetApiResponse;

public interface PetStoreRepository {

    GetPetApiResponse findById(Long petId);
    CreatePetApiResponse create(CreatePetApiRequest createPetApiRequest);
}
