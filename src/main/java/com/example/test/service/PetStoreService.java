package com.example.test.service;

import com.example.test.domain.Pet;
import com.example.test.dto.PetCreatedResponse;
import com.example.test.dto.PetResponse;
import com.example.test.entity.CreatePetApiRequest;
import com.example.test.entity.CreatePetApiResponse;
import com.example.test.entity.GetPetApiResponse;
import com.example.test.repository.rest.PetStoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.example.test.mapper.PetMapper.*;

@Service
public class PetStoreService {

    private static final Logger log = LoggerFactory.getLogger(PetStoreService.class);
    private final PetStoreRepository petStoreRepository;

    public PetStoreService(PetStoreRepository petStoreRepository) {
        this.petStoreRepository = petStoreRepository;
    }

    public PetResponse findById(Long petId) {
        GetPetApiResponse getPetApiResponse = petStoreRepository.findById(petId);
        log.info("Pet found with id: {}", petId);

        return toResponse(getPetApiResponse);
    }

    public PetCreatedResponse create(Pet pet) {

        CreatePetApiRequest request = toApiRequest(pet);

        CreatePetApiResponse apiResponse = petStoreRepository.create(request);
        log.info("Creating Pet found with request: {}", apiResponse);

        return toPetCreateResponse(apiResponse);
    }

}
