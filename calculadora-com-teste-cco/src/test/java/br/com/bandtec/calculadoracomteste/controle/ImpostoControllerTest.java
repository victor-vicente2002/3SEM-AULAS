package br.com.bandtec.calculadoracomteste.controle;

import br.com.bandtec.calculadoracomteste.dominio.Imposto;
import br.com.bandtec.calculadoracomteste.repositorio.ImpostoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/*
@SpringBootTest -> Esta anotação faz com que seja possível integrar componentes do projeto Spring
nos testes da classe. Por exemplo, podemo usar o @Autowired e @MockBean.
 */
@SpringBootTest
class ImpostoControllerTest {

    @Autowired // aqui funciona como nas demais classes Spring, para INJETAR componentes Spring
    ImpostoController controller;

    /*
    @MockBean -> Injeta um MOCK (dublê) de um componente Spring.
    Assim, TODO componente que injetar ImpostoRepository com @Autowired, na verdade, terá um Mock
     */
    @MockBean
    ImpostoRepository repository;

    @Test
    @DisplayName("GET /impostos - Quando houverem registros - status 200 e número certo de registros")
    void getImpostosComRegistros() {

        // aqui criamos uma lista que vai ser como se fosse a lista vinda do banco de dados
        List<Imposto> impostosTeste = Arrays.asList(new Imposto(), new Imposto(), new Imposto());

        /*
        Aqui nós ENSIMOS o Mock a fazer uma coisa:
        Quando alguém invocar o método "findAll()" do objeto "repository", retorne a "impostosTeste"

        Mockito -> Uma classe de uma biblioteca de testes chamada Mockito
                   Essa biblioteca, como o nome sugere, facilita a criação e programação de Mocks
         */
        Mockito.when(repository.findAll()).thenReturn(impostosTeste);

        ResponseEntity<List<Imposto>> resposta = controller.getImpostos();

        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(3, resposta.getBody().size());
    }

    @Test
    @DisplayName("GET /impostos - Quando NÃO houverem registros - status 204 e sem corpo")
    void getImpostosSemRegistros() {
        Mockito.when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity<List<Imposto>> resposta = controller.getImpostos();

        assertEquals(204, resposta.getStatusCodeValue());
        assertNull(resposta.getBody()); // verifica se resposta.getBody() é null
    }

    @Test
    void postImpostoSemErros() {

        // Bloco GIVEN (Dado) - preparando tudo que for necessário para a execução do teste
        Imposto imposto = new Imposto();
        imposto.setNome("ICMS");
        imposto.setAliquota(0.03);

        /*
        Por padrão, quando não configuramos o que um método de um mock faz, ele NÃO dá erro
        Por isso, nem precisamos "mockar" o método "save()" do repository
        Quando um método de mock tem retorno e não programamos, seus retornos padrão costumam ser:
        * boolean -> false
        * int, double etc -> 0
        * Lista -> Lista vazia
        * Array(vetor) -> Vetor vazio
        * Qualquer outro tipo -> null
         */

        // Bloco WHEN (Quando) - execução do teste e armazenamento do resultado
        ResponseEntity resposta = controller.postImpostos(imposto);

        // Bloco THEN (Então) - asserções do teste
        assertEquals(201, resposta.getStatusCodeValue());
    }

    @Test
    void putImpostoQueExiste() {
        int idTeste = 10;
        Imposto impostoTeste = new Imposto();

        Mockito.when(repository.existsById(idTeste)).thenReturn(true);

        ResponseEntity resposta = controller.putImpostos(impostoTeste, idTeste);

        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(idTeste, impostoTeste.getId());
    }

    @Test
    void putImpostoQueNaoExiste() {
        int idTeste = 51;
        Imposto impostoTeste = new Imposto();

        Mockito.when(repository.existsById(idTeste)).thenReturn(false);

        ResponseEntity resposta = controller.putImpostos(impostoTeste, idTeste);

        assertEquals(404, resposta.getStatusCodeValue());
    }

}