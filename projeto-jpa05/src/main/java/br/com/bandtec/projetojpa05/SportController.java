package br.com.bandtec.projetojpa05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/esportes")
public class SportController {

    @Autowired
    private SportRepository repository;

    @Autowired
    private SportCategoryRepository categoryRepository;

    @GetMapping()
    private ResponseEntity getSports() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @PostMapping
    public ResponseEntity postSport(@RequestBody Sport sport){
        if (categoryRepository.existsById(sport.getCategory().getId())) {
            repository.save(sport);
            return ResponseEntity.status(201).build();
        }else {
            return ResponseEntity.status(400).body("Categoria não existe!");
        }
    }

    @GetMapping("categoria/{idCategory}")
    public ResponseEntity getSportByCategory(@PathVariable Integer idCategory) {
        return ResponseEntity.ok().body(repository.getSportByCategoryId(idCategory));
    }
}
