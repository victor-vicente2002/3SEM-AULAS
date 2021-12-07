package br.com.bandtec.projeto04;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private List<Cliente> clientes = new ArrayList<>();

    public ClienteController() {
        this.clientes.add(new Cliente("Valeska", 30_000.0));
        this.clientes.add(new Cliente("Thomas", 1_000.0));
        this.clientes.add(new Cliente("Jane", 5_000.0));
        this.clientes.add(new Cliente("Tarzan", 500.0));
    }

    @GetMapping("/{posicao}")
    public Cliente getCliente(@PathVariable int posicao) {
        if (posicao < clientes.size()){
            return clientes.get(posicao);
        }
        else {
            return null;
        }
    }

//    @DeleteMapping("/{posicao}")
//    public String removeCliente(@PathVariable int posicao) {
//        if (posicao < clientes.size()){
//            clientes.remove(posicao);
//            return "CLiente removido com sucesso!";
//        }
//        else {
//            return "Cliente não encontrado";
//        }
//    }
//
//    @PostMapping
//    public String postCliente(@RequestBody Cliente clienteNovo) {
//        clientes.add(clienteNovo);
//        return "Cliente cadastrado com sucesso";
//    }
//
//    @GetMapping("/mais-ricos")
//    public List getMaisRicos() {
//        List<Cliente> listaRicos = new ArrayList<>();
//        for (Cliente c : clientes) {
//            if (c.getRenda() > 15_000.00) {
//                listaRicos.add(c);
//            }
//        }
//        return listaRicos;
//    }

}
