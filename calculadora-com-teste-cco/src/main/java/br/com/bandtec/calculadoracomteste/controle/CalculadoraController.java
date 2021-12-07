package br.com.bandtec.calculadoracomteste.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    @GetMapping("/inss/{salario}")
    public ResponseEntity calcularInss(@PathVariable double salario) {
        if (salario < 1000) {
            return ResponseEntity.status(400).body("Salário inválido");
        }

        double inss = salario * 0.08;
        return ResponseEntity.status(200).body(inss);
    }
}
