package br.com.bandtec.projetojpa04.controller;

import br.com.bandtec.projetojpa04.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository repository;

//     @GetMapping
//    public ResponseEntity getFilmes(@RequestParam String diretor) {
//        return ResponseEntity.status(200).body(repository.findByDiretor(diretor));
//    }

    @GetMapping
    public ResponseEntity getFilmes(@RequestParam String diretor, @RequestParam boolean classico) {
        return ResponseEntity.status(200).body(repository.findByDiretorContainsAndClassico(diretor, classico));
    }

    @GetMapping("/classicos")
    public ResponseEntity getClassicos() {
        return ResponseEntity.status(200).body(repository.findByClassicoTrue());
    }

    @GetMapping("/simples")
    public ResponseEntity getSimples() {
        return ResponseEntity.status(200).body(repository.findAllSimples());
    }
}
