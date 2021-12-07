package br.com.bandtec.projetojpa05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/esportes")
public class EsporteController {

    @Autowired
    private EsporteRepository repository;

    @Autowired
    private TipoEsporteRepository tipoEsporteRepository;

    @PostMapping
    public ResponseEntity postEsporte(@RequestBody Esporte novoEsporte) {
        if (tipoEsporteRepository.existsById(novoEsporte.getTipo().getId())) {
            repository.save(novoEsporte);
            return ResponseEntity.status(201).build();
        } else {
            return ResponseEntity.status(400).body("Tipo de esporte não encontrado!");
        }
    }

    @GetMapping
    public ResponseEntity getEsportes() {
        return ResponseEntity.status(200).body(
                repository.findAll().stream().map(EsporteSimplesResposta::new)
                    .collect(Collectors.toList()));
    }

    @GetMapping("/tipo/{idTipo}")
    public ResponseEntity getEsportesPorTipo(@PathVariable Integer idTipo) {
        return ResponseEntity.status(200).body(repository.pesquisarPorTipo(idTipo));
    }
}
