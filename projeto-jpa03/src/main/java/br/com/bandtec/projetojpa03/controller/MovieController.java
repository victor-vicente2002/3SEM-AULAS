package br.com.bandtec.projetojpa03.controller;

import br.com.bandtec.projetojpa03.dominio.Movie;
import br.com.bandtec.projetojpa03.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository repository;

    @PostMapping
    public ResponseEntity postMovie(@RequestBody @Valid Movie newMovie) {
        repository.save(newMovie);
        return ResponseEntity.status(201).build();
    }
}
