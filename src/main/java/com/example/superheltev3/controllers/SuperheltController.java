package com.example.superheltev3.controllers;

import com.example.superheltev3.model.Superheroes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.superheltev3.services.SuperheltService;

import java.util.List;

@Controller
@RequestMapping("superhelte")
public class SuperheltController {
    private SuperheltService superheltService;

    public SuperheltController(SuperheltService superheltService) {
        this.superheltService = superheltService;
    }

    @RequestMapping("/")
    public ResponseEntity<?> printSuperhelte(@RequestParam(required = false) String format) {
        List<Superheroes> superhelte = superheltService.getSuperhelte();
        for (Superheroes superhero : superhelte) {
            superhero.getFirstName();
            superhero.getLastName();
            superhero.getAlias();
            superhero.getYearOfOrigin();
            superhero.getPowerlvl();
            superhero.getRace();
            superhero.getPowers();
        }
            return new ResponseEntity<>(superhelte, HttpStatus.OK);
    }

    @RequestMapping(path = "/{navn}")
    public ResponseEntity<List<Superheroes>> printSpecifikSuperhelt(@PathVariable String navn) {
        List<Superheroes> searchResults = superheltService.searchForSuperhero(navn);
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }

    @PostMapping(path = "/opret")
    public ResponseEntity<Superheroes> opretSuperhelt(@RequestBody Superheroes superheroes) {
        Superheroes newSuperhero = superheltService.createSuperHero(superheroes.getFirstName(), superheroes.getLastName(), superheroes.getAlias(), superheroes.getPowers(), superheroes.getYearOfOrigin(), superheroes.getPowerlvl(), superheroes.getRace());
        return new ResponseEntity<Superheroes>(newSuperhero, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/slet/{navn}")
    public ResponseEntity<List<Superheroes>> sletSuperhelt(@PathVariable String navn) {
        List<Superheroes> slettetSuperhelt= superheltService.deleteSuperhero(navn);
        return new ResponseEntity(slettetSuperhelt,HttpStatus.OK);
    }
}
