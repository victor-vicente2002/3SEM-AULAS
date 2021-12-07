package br.com.bandtec.projetojpa01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/treinadores")
public class TreinadorController {

    @Autowired
    private TreinadorRepository repository;

    @GetMapping
    public ResponseEntity getAllTreiners() {
        List<TreinadorPokemon> listTrainers = repository.findAll();

        if (listTrainers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok().body(listTrainers);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTrainer(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/contagem")
    public ResponseEntity getNumberOfTreiners() {
        return ResponseEntity.status(200).body(repository.count());
    }

    @GetMapping("/{id}")
    public ResponseEntity getTrainer(@PathVariable Integer id) {
        return ResponseEntity.of(repository.findById(id));
    }


}
