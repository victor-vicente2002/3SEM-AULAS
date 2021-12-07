package br.com.bandtec.projetojpa05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipos")
public class TipoEsporteController {

    @Autowired
    private TipoEsporteRepository repository;

    @PostMapping
    public ResponseEntity postTipo(@RequestBody TipoEsporte novoTipo) {
        repository.save(novoTipo);

        return ResponseEntity.status(201).build();
    }
}
