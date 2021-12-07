package br.com.bandtec.projeto02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acessos")
public class AcessosControler {

    private int acessos = 0;

    @GetMapping("/contar")
    public String contarAcessos(){
        acessos++;
        return "Você já acessou a API " +acessos+" vezes";
    }

}
