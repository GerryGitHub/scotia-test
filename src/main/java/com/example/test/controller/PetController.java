package com.example.test.controller;

import com.example.test.dto.PetCreatedResponse;
import com.example.test.dto.PetRequest;
import com.example.test.dto.PetResponse;
import com.example.test.service.PetStoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.test.mapper.PetMapper.toPet;

@RestController
@RequestMapping("/api/pet")
public class PetController {

    private final PetStoreService petStoreService;

    public PetController(PetStoreService petStoreService) {
        this.petStoreService = petStoreService;
    }

    @GetMapping("/{idPet}")
    public ResponseEntity<PetResponse> getPet(
            @PathVariable Long idPet
    ) {

        return ResponseEntity.ok(
                petStoreService.findById(idPet)
        );
    }

    @PostMapping
    public ResponseEntity<PetCreatedResponse> createPet(
            @RequestBody PetRequest petRequest
    ){
        return ResponseEntity.ok(
                petStoreService.create(toPet(petRequest))
        );
    }


}
