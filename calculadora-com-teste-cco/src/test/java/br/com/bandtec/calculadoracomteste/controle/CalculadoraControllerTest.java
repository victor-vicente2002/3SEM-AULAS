package br.com.bandtec.calculadoracomteste.controle;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

// Esta é uma classe de testes UNITÁRIOS (ou Testes de Unidade)
class CalculadoraControllerTest {

    @Test // esta anotação indica que esta classe realizará 1 ou mais testes unitários
    void calcularInssSalario1000() {
        // Aqui estamos preparando a execução
        CalculadoraController controller = new CalculadoraController();

        // Aqui estamos executando o que queremos testar
        ResponseEntity resposta = controller.calcularInss(1000.0);

        // Aqui estamos fazendo as asserções (ou verificações) da execução do método

        // assertEquals() testa se o valor do 1º parâmetro é igual ao valor do 2º parâmetro
        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(80.0, resposta.getBody());
    }

    @Test
    void calcularInssSalario0() {
        CalculadoraController controller = new CalculadoraController();
        ResponseEntity resposta = controller.calcularInss(0.0);

        assertEquals(400, resposta.getStatusCodeValue());
        assertEquals("Salário inválido", resposta.getBody());
    }
}