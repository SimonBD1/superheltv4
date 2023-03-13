package com.example.superheltev3.controllers;


import com.example.superheltev3.DTO.CountPowerDTO;
import com.example.superheltev3.DTO.HeroCityDTO;
import com.example.superheltev3.DTO.HeroPowerDTO;
import com.example.superheltev3.DTO.SuperheroDTO;
import com.example.superheltev3.services.MyService;
import com.example.superheltev3.model.Superheroes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "kea")
public class MyController {

    private MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping(path = "superheroes")     //localhost:8181/superheroes
    public ResponseEntity<List<SuperheroDTO>> getSuperheroes() {
        List<SuperheroDTO> superheroesList = myService.getSuperheroes();
        return new ResponseEntity<>(superheroesList, HttpStatus.OK);
    }

    @GetMapping(path = "superhero/{name}")      //localhost:8181/superhero/{name}
    public ResponseEntity<Superheroes> superheroByName(@PathVariable String name) {
        Superheroes superheroByName = myService.searchSuperhero(name);
        return new ResponseEntity<>(superheroByName, HttpStatus.OK);
    }

    @GetMapping(path = "superpower/{name}")     //localhost:8181/superpower/{name}
    public ResponseEntity<HeroPowerDTO> powerByName(@PathVariable String name) {
        HeroPowerDTO powerByName = myService.heroPowerByName(name);
        return new ResponseEntity<>(powerByName, HttpStatus.OK);
    }

    @GetMapping(path = "city/{city}")
    public ResponseEntity <List<HeroCityDTO>> heroByCity(@PathVariable String city) {
        List<HeroCityDTO> heroByCityName = myService.heroByCityName(city);
        return new ResponseEntity<>(heroByCityName, HttpStatus.OK);
    }

    @GetMapping (path = "/superpower/count/{name}")
    public ResponseEntity<CountPowerDTO> powerCountByName (@PathVariable("name") String name) {
        CountPowerDTO countPowerDTO = myService.countPowerDTO(name);
        return new ResponseEntity<>(countPowerDTO, HttpStatus.OK);
    }
}

