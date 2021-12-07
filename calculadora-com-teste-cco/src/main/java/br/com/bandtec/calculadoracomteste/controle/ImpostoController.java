package br.com.bandtec.calculadoracomteste.controle;

import br.com.bandtec.calculadoracomteste.agendamento.AgendamentoService;
import br.com.bandtec.calculadoracomteste.dominio.Imposto;
import br.com.bandtec.calculadoracomteste.repositorio.ImpostoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/impostos")
public class ImpostoController {

    @Autowired
    private ImpostoRepository repository;

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping
    public ResponseEntity<List<Imposto>> getImpostos() {
//        agendamentoService.setPilha(pilha);
        List<Imposto> impostos = repository.findAll();
        return impostos.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(impostos);
    }

    @PostMapping
    public ResponseEntity postImpostos(@RequestBody @Valid Imposto novoImposto) {
        repository.save(novoImposto);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity putImpostos(@RequestBody @Valid Imposto imposto, @PathVariable int id) {
        if (repository.existsById(id)) {
            imposto.setId(id);
            repository.save(imposto);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

}
