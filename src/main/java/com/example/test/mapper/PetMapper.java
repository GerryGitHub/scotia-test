package com.example.test.mapper;

import com.example.test.domain.Pet;
import com.example.test.dto.PetCreatedResponse;
import com.example.test.dto.PetRequest;
import com.example.test.dto.PetResponse;
import com.example.test.entity.CreatePetApiRequest;
import com.example.test.entity.CreatePetApiResponse;
import com.example.test.entity.GetPetApiResponse;

import java.time.LocalDateTime;
import java.util.UUID;

public class PetMapper {

    public static PetResponse toResponse(GetPetApiResponse getPetApiResponse) {
        return new PetResponse(
                getPetApiResponse.id(),
                getPetApiResponse.name(),
                getPetApiResponse.status()
        );
    }

    public static CreatePetApiRequest toApiRequest(Pet pet) {
        return new CreatePetApiRequest(
                pet.id(),
                pet.name(),
                pet.status()
        );
    }


    public static PetCreatedResponse toPetCreateResponse(CreatePetApiResponse createPetApiResponse) {
        return new PetCreatedResponse(
                UUID.randomUUID(),
                LocalDateTime.now(),
                "available".equals(createPetApiResponse.status()),
                createPetApiResponse.name()

        );
    }

    public static Pet toPet(PetRequest petRequest) {
        return new Pet(
                petRequest.id(),
                petRequest.name(),
                petRequest.status()
        );
    }
}
