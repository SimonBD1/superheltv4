package com.example.superheltev3.services;

import com.example.superheltev3.DTO.CountPowerDTO;
import com.example.superheltev3.DTO.HeroCityDTO;
import com.example.superheltev3.DTO.HeroPowerDTO;
import com.example.superheltev3.DTO.SuperheroDTO;
import com.example.superheltev3.model.Superheroes;
import com.example.superheltev3.repositories.MyRepository_DB;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.List;

@SpringBootApplication

@Service
public class MyService {

    MyRepository_DB myRepositoryDB;

    public MyService(MyRepository_DB myRepositorydb) {
        this.myRepositoryDB = myRepositorydb;
    }

    public List<SuperheroDTO> getSuperheroes() {
        return myRepositoryDB.getSuperheroes();
    }

    public Superheroes searchSuperhero(String name) {
        return myRepositoryDB.searchHeroByName(name);
    }

    public HeroPowerDTO heroPowerByName (String name){
        return myRepositoryDB.heroPowerByName(name);
    }

    public List <HeroCityDTO> heroByCityName (String city){
        return myRepositoryDB.heroByCity(city);
    }

    public void createSuperhero (String heroName, String realName){
    }
    public CountPowerDTO countPowerDTO (String name){
        return myRepositoryDB.heroPowerCounter(name);
    }
}
