package com.example.superheltev3.model;

public class Superheroes {
        private int heroID;
        private String heroName;
        private String realName;
        private int creationYear;
        private int superpowerID;
        private int cityID;

        public Superheroes(int heroID, String heroName, String realName, int creationYear, int superpowerID, int cityID) {
            this.heroID = heroID;
            this.heroName = heroName;
            this.realName = realName;
            this.creationYear = creationYear;
            this.superpowerID = superpowerID;
            this.cityID = cityID;
        }
        public Superheroes(){

        }

        public int getHeroID() {
            return heroID;
        }

        public String getHeroName() {
            return heroName;
        }

        public String getRealName() {
            return realName;
        }

        public int getCreationYear() {
            return creationYear;
        }

        public int getSuperpowerID() {
            return superpowerID;
        }

        public int getCityID() {
            return cityID;
        }
    }