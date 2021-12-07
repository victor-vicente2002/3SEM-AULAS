package br.com.bandtec.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class PaisesControler {

    @GetMapping
    public String padrao(){
        return "Conheça os paises!";
    }

    @GetMapping("/mexico")
    public String mexico(){
        return "Obrigado pelo Chaves";
    }

    @GetMapping("/cuba")
    public String cuba(){
        return "Melhores charutos do mundo!";
    }

    @GetMapping("/canada")
    public String canada(){
        return "Pedimos desculpas por qualqer coisa";
    }

}
