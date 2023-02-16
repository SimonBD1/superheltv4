package com.example.superheltev3.services;

import com.example.superheltev3.model.Superheroes;
import org.springframework.stereotype.Service;
import com.example.superheltev3.repositories.SuperheltRepository;

import java.util.List;

@Service
public class SuperheltService {
    private SuperheltRepository superheltRepository;

    public SuperheltService(SuperheltRepository superheltRepository) {
        this.superheltRepository = superheltRepository;
    }

    public List<Superheroes> getSuperhelte() {
        return superheltRepository.getSuperHeroesDB();
    }

    public List<Superheroes> searchForSuperhero(String searchTerm) {
        return superheltRepository.searchSuperhero(searchTerm);
    }

    public Superheroes createSuperHero(String firstName, String lastName, String alias, String powers, int yearOfOrigin, double powerlvl, boolean race) {
        return superheltRepository.createSuperHero(firstName, lastName, alias, powers, yearOfOrigin, powerlvl, race);
    }

    public List<Superheroes> deleteSuperhero(String navn) {
        return superheltRepository.deleteSuperheroes(navn);
    }
}
