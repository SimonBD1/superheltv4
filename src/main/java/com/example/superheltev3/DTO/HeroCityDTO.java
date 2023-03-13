package com.example.superheltev3.DTO;

public class HeroCityDTO {

    private String realName;
    private String city;

    public HeroCityDTO(String realName, String city) {
        this.realName = realName;
        this.city = city;
    }

    public String getRealName() {
        return realName;
    }

    public String getCity() {
        return city;
    }
}
