package com.example.test.repository.rest.impl;

import com.example.test.entity.CreatePetApiRequest;
import com.example.test.entity.CreatePetApiResponse;
import com.example.test.entity.GetPetApiResponse;
import com.example.test.repository.rest.PetStoreRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

@Repository
public class PetStoreRepositoryImpl implements PetStoreRepository {

    private final RestClient restClient;
    private final String petEndpoint;
    private final String petByIdEndpoint;

    public PetStoreRepositoryImpl(
            RestClient restClient,
            @Value("${petstore.endpoints.pet}") String petEndpoint,
            @Value("${petstore.endpoints.pet-by-id}") String petByIdEndpoint
    ) {
        this.restClient = restClient;
        this.petEndpoint = petEndpoint;
        this.petByIdEndpoint = petByIdEndpoint;
    }

    @Override
    public GetPetApiResponse findById(Long petId) {

        return restClient.get()
                .uri(petByIdEndpoint, petId)
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        (request, response) -> {
                            throw new RuntimeException("Pet no encontrado");
                        })
                .onStatus(
                        HttpStatusCode::is5xxServerError,
                        (request, response) -> {
                            throw new RuntimeException("Error del servidor");
                        })
                .body(GetPetApiResponse.class);
    }

    @Override
    public CreatePetApiResponse create(CreatePetApiRequest createPetApiRequest) {

        return restClient.post()
                .uri(petEndpoint)
                .body(createPetApiRequest)
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        (request, response) -> {
                            throw new RuntimeException("Error al crear el Pet.");
                        })
                .onStatus(
                        HttpStatusCode::is5xxServerError,
                        (request, response) -> {
                            throw new RuntimeException("Error del servidor");
                        })
                .body(CreatePetApiResponse.class);
    }
}
