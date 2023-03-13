package com.example.superheltev3.repositories;

import com.example.superheltev3.DTO.CountPowerDTO;
import com.example.superheltev3.DTO.HeroCityDTO;
import com.example.superheltev3.DTO.HeroPowerDTO;
import com.example.superheltev3.DTO.SuperheroDTO;
import com.example.superheltev3.model.Superheroes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MyRepository_DB implements repo {

    @Value("${spring.datasource.url}")
    private String db_url;

    @Value("${spring.datasource.username}")
    private String uid;

    @Value("${spring.datasource.password}")
    private String pwd;

    @Override
    public List<SuperheroDTO> getSuperheroes() {
        List<SuperheroDTO> superheroes = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT realname, heroName, creation_year FROM SUPERHERO";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                String realName = rs.getString("REALNAME");
                String heroName = rs.getString("HERONAME");
                int creationYear = rs.getInt("CREATION_YEAR");

                superheroes.add(new SuperheroDTO(realName, heroName, creationYear));
            }
            return superheroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Superheroes searchHeroByName(String name) {
        Superheroes heroObj = null;
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT * FROM SUPERHERO WHERE HERO_NAME = ?";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int ID = rs.getInt("SUPERHERO_ID");
                String heroName = rs.getString("HERO_NAME");
                String realName = rs.getString("REAL_NAME");
                int creationYear = rs.getInt("CREATION_YEAR");
                int superpowerID = rs.getInt("SUPERPOWER_ID");
                int cityID = rs.getInt("CITY_ID");
                heroObj = new Superheroes(ID, heroName, realName, creationYear, superpowerID, cityID);
            }
            return heroObj;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public HeroPowerDTO heroPowerByName(String name) {
        HeroPowerDTO heroPowerObj = null;

        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT heroname, REALNAME, NAME FROM SUPERHERO INNER JOIN SUPERPOWER WHERE NAME = ?";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String heroName = rs.getString("HERONAME");
                String realName = rs.getString("REALNAME");
                String superpower = rs.getString("name");
                heroPowerObj = new HeroPowerDTO(heroName, realName, superpower);
            }
            return heroPowerObj;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<HeroCityDTO> heroByCity(String city) {
        List<HeroCityDTO> heroCityDTOList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "select name, heroname from superhero inner join city using (city_id) where name = ? order by name;";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, city);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String heroName = rs.getString("HERONAME");
                String cityName = rs.getString("NAME");
                heroCityDTOList.add(new HeroCityDTO(heroName, cityName));
            }
            return heroCityDTOList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CountPowerDTO heroPowerCounter(String name) {
        CountPowerDTO countPowerDTO = null;
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT superhero.heroname , COUNT(superpower.power_id) AS superpowerCount FROM superhero join superpower on superhero.hero_id = superpower.power_id where superhero.heroname = ? group by superhero.heroname;";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String heroName = rs.getString("Heroname");
                int countPower = rs.getInt("superpowercount");
                countPowerDTO = new CountPowerDTO(heroName, countPower);
            }
            return countPowerDTO;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}