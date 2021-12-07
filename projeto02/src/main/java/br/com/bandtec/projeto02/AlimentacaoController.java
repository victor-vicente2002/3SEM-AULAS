package br.com.bandtec.projeto02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alimentacao")
public class AlimentacaoController {

    @GetMapping
    public String padrao(){
        return "API braba de alimentação saudável!!";
    }

    @GetMapping("/frutas-dia/{frutas}")
    public String analisarConsumoFrutas(@PathVariable int frutas){
        if (frutas <3){
            return "Você come poucas frutas por dia!";
        }
        else if (frutas < 10 ){
            return "Você come uma boa quantidade de frutas por dia!";
        }
        else{
            return "Você tem uma CEASA na barriga! Parabéns!";
        }
    }

    @GetMapping("/vitamina/{fruta1}/{fruta2}")
    public String verVitaminas(@PathVariable String fruta1, @PathVariable String fruta2){
        return "Saindo uma vitamina de " + fruta1 + " com " + fruta2;
    }

    @GetMapping("/milkshake/{sabor}/{quantidade}/{comChantilly} ")
    public String pedirMilkshake(@PathVariable String sabor, @PathVariable int quantidade,
                                 @PathVariable Boolean comChantilly){

        if (quantidade <= 0){
            return "Onde já se viu comprar essa quantidade?";
        }else{
            Double preco;
            if (comChantilly){
                preco = 12.00;
            }else{
                preco = 10.00;
            }
            return "Seus " + quantidade + " shakes de " + sabor + " vão custar " + quantidade * preco;
        }
    }
}
