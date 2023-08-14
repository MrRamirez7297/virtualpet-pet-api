package com.example.virtualpetapi.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.virtualpetapi.model.VirtualPet;
import com.example.virtualpetapi.repository.VirtualPetRepo;

@Configuration
public class LoadDatabase {
    

    @Bean
    public CommandLineRunner loadDB(VirtualPetRepo virtualPetRepo) {
        return args -> {
            VirtualPet pet1 = new VirtualPet("Ace");
            VirtualPet pet2 = new VirtualPet("Spike");
            VirtualPet pet3 = new VirtualPet("Sparks");
            VirtualPet pet4 = new VirtualPet("Garfield");

            virtualPetRepo.save(pet1);
            virtualPetRepo.save(pet2);
            virtualPetRepo.save(pet3);
            virtualPetRepo.save(pet4);
        };
    }
}
