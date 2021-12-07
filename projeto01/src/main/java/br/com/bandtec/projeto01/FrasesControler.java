package br.com.bandtec.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrasesControler {

    @GetMapping
    public String padrao(){
        return "API de Frases educadas";
    }

    @GetMapping("/bom-dia")
    public String bomDia(){
        return "Bom dia, galera";
    }

    @GetMapping("/boa-tarde")
    public String boaTarde(){
        return "Bom tarde, meu povo";
    }

}
