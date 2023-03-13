package com.example.superheltev3.repositories;

import com.example.superheltev3.DTO.CountPowerDTO;
import com.example.superheltev3.DTO.HeroCityDTO;
import com.example.superheltev3.DTO.HeroPowerDTO;
import com.example.superheltev3.DTO.SuperheroDTO;
import com.example.superheltev3.model.Superheroes;

import java.util.List;

public interface repo {
    public List<SuperheroDTO> getSuperheroes();
    public Superheroes searchHeroByName(String name);

    public HeroPowerDTO heroPowerByName(String name);

    public List<HeroCityDTO> heroByCity(String city);

    public CountPowerDTO heroPowerCounter (String name);

}
