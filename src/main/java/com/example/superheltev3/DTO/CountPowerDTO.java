package com.example.superheltev3.DTO;

public class CountPowerDTO {
    public String getSuperHeroName() {
        return superHeroName;
    }

    public void setSuperHeroName(String superHeroName) {
        this.superHeroName = superHeroName;
    }

    public int getCountPower() {
        return countPower;
    }

    public void setCountPower(int countPower) {
        this.countPower = countPower;
    }

    public CountPowerDTO(String superHeroName, int countPower) {
        this.superHeroName = superHeroName;
        this.countPower = countPower;
    }

    private String superHeroName;
    private int countPower;

}
