package com.example.virtualpetapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.virtualpetapi.model.VirtualPet;
import com.example.virtualpetapi.repository.VirtualPetRepo;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private VirtualPetRepo virtualPetRepo;

    @GetMapping("")
    public ResponseEntity<List<VirtualPet>> getAllPets() {
        List<VirtualPet> pets = (List<VirtualPet>) virtualPetRepo.findAll();
        if (pets.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VirtualPet> getPet(@PathVariable Long id) {
        return virtualPetRepo.findById(id)
                .map(pet -> new ResponseEntity<>(pet, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VirtualPet> deletePet(@PathVariable Long id) {
        return virtualPetRepo.findById(id)
                .map(pet -> {
                    virtualPetRepo.deleteById(id);
                    return new ResponseEntity<>(pet, HttpStatus.OK);
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/new")
    public ResponseEntity<VirtualPet> addPet(@RequestBody VirtualPet pet) {
        VirtualPet savedPet = virtualPetRepo.save(pet);
        return new ResponseEntity<>(savedPet, HttpStatus.CREATED);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<VirtualPet> updatePet(@PathVariable Long id, @RequestBody VirtualPet updatedPet) {
        return virtualPetRepo.findById(id)
                .map(existingPet -> {
                    if (updatedPet.getName() != null)
                        existingPet.setName(updatedPet.getName());
                   // if (updatedPet.getModel() != null)
                   //     existingPet.setMake(updatedPet.getMake());
                   // if (updatedPet.getModel() != null)
                   //     existingPet.setModel(updatedPet.getModel());
                    VirtualPet savedPet = virtualPetRepo.save(existingPet);
                    return new ResponseEntity<>(savedPet, HttpStatus.OK);
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}