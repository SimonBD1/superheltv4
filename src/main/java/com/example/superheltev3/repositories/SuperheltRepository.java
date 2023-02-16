package com.example.superheltev3.repositories;

import com.example.superheltev3.model.Superheroes;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperheltRepository {
    Superheroes superheroes = new Superheroes("Kjart", "Kjart", "Mandemanden", "Fodbold", 2211, 9, true);
    Superheroes superheroes1 = new Superheroes("Tobi", "Tobi", "Mandemanden", "Fodbold", 2211, 9, true);
    private List<Superheroes> superHeroesDB = new ArrayList<>(List.of(superheroes, superheroes1));

    public void createTestData() {
        Superheroes superheroes = new Superheroes("Kjart", "Kjart", "Mandemanden", "Fodbold", 2211, 9, true);
        Superheroes superheroes1 = new Superheroes("Tobi", "Tobi", "Mandemanden", "Fodbold", 2211, 9, true);

        superHeroesDB.add(superheroes);
        superHeroesDB.add(superheroes1);

        createSuperHero("Manner", "Mogensen", "Mugge", "Flyve stærkt", 1888, 12.2, true);
        createSuperHero("Mandrup", "Plum", "Plummesen", "Flyve langsomt", 1995, 1.2, true);
        createSuperHero("Kjart", "Kjart", "Mandemanden", "Fodbold", 2211, 9, true);
        createSuperHero("Tobi", "Tobi", "Bassemanden", "Bare tænk på hulk", 2001, 12.2, true);
    }

    public List<Superheroes> getSuperHeroesDB() {
        return superHeroesDB;
    }

    public List<Superheroes> searchSuperhero(String searchTerm) {
        List<Superheroes> searchResult = new ArrayList<>();

        for (Superheroes superheroes : superHeroesDB) {
            if (superheroes.getFirstName().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchResult.add(superheroes);
            }
            if (superheroes.getLastName().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchResult.add(superheroes);
            }
        }
        return searchResult;
    }

    public Superheroes createSuperHero(String firstName, String lastName, String alias, String powers, int yearOfOrigin, double powerlvl, boolean race) {

        Superheroes hero = new Superheroes(firstName, lastName, alias
                , powers, yearOfOrigin, powerlvl, race);

        superHeroesDB.add(hero);
        return hero;
    }

    public Superheroes deleteSuperheroes(String navn) {
        for (Superheroes superheroes : superHeroesDB) {
            if (superheroes.getFirstName().toLowerCase().contains(navn.toLowerCase())) {
                if (superheroes.getFirstName().contains(navn)) {
                    getSuperHeroesDB().remove(superheroes);
                }
            }
        }return superheroes;
    }
}
