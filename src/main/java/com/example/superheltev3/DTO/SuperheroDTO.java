package com.example.superheltev3.DTO;

public class SuperheroDTO {
    public SuperheroDTO(String realName, String heroName, int creationYear) {
        this.realName = realName;
        this.heroName = heroName;
        this.creationYear = creationYear;
    }

    public String getRealName() {
        return realName;
    }

    public String getHeroName() {
        return heroName;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public String realName;
    public String heroName;
    public int creationYear;


}
