package com.example.superheltev3.DTO;

import com.example.superheltev3.model.Superheroes;

import java.util.List;

public class HeroPowerDTO {
    private String heroName;
    private String realName;
    private String superpowers;

    public HeroPowerDTO(String heroName, String realName, String superpowers) {
        this.heroName = heroName;
        this.realName = realName;
        this.superpowers = superpowers;
    }

    public String getHeroName() {
        return heroName;
    }

    public String getRealName() {
        return realName;
    }

    public String getSuperpowers() {
        return superpowers;
    }

}
