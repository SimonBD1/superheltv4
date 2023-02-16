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
@RequestMapping( "superhelte")
public class SuperheltController {
    private SuperheltService superheltService;
    public SuperheltController(SuperheltService superheltService) {
        this.superheltService = superheltService;
    }

    @RequestMapping("/")
    public ResponseEntity<?> printSuperhelte(@RequestParam(required = false) String format) {
        List<Superheroes> superhelte = superheltService.getSuperhelte();
        if (format != null && format.equals("html")) {
            StringBuilder html = new StringBuilder();
            html.append("<table>");
            html.append("<tr><th>Superhero Name</th><th>Real Name</th><th>Creation Year</th><th>Superpower</th>" +
                    "<th>Is Human</th><th>Power</th></tr>");
            for (Superheroes superhero : superhelte) {
                html.append("<tr><td>").append(superhero.getFirstName()).append("</td>");
                html.append("<tr><td>").append(superhero.getLastName()).append("</td>");
                html.append("<td>").append(superhero.getAlias()).append("</td>");
                html.append("<td>").append(superhero.getYearOfOrigin()).append("</td>");
                html.append("<td>").append(superhero.getPowerlvl()).append("</td>");
                html.append("<td>").append(superhero.getRace()).append("</td>");
                html.append("<td>").append(superhero.getPowers()).append("</td></tr>");
            }
            html.append("</table>");
            HttpHeaders headers = new HttpHeaders();
            headers.add("content-type", "text/html");
            return new ResponseEntity<>(html.toString(), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(superhelte, HttpStatus.OK);
        }
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
        superheltService.deleteSuperhero(navn);
        return new ResponseEntity(HttpStatus.OK);
    }
}
