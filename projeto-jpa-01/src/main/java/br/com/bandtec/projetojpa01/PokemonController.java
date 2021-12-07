package br.com.bandtec.projetojpa01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.DescriptorKey;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    @Autowired
    private PokemonRepository repository;

    @GetMapping
    public List<Pokemon> getPokemons() {
        return repository.findAll();
    }

    @PostMapping
    public String postPokemons(@RequestBody Pokemon newPokemons) {
        repository.save(newPokemons);
        return "Salvo com sucesso!";
    }

    @GetMapping("/{id}")
    public Pokemon getPokemon(@PathVariable Integer id) {
        Optional<Pokemon> pokemonOptinal = repository.findById(id);

        if (pokemonOptinal.isPresent()) {
            return pokemonOptinal.get();
        }else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String deletePokemon(@PathVariable Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Excluído!";
        }else { return "Não encontrado"; }
    }
}
