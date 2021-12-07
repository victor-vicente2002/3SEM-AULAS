package br.com.bandtec.projetojpa04.repository;

import br.com.bandtec.projetojpa04.dominio.Filme;
import br.com.bandtec.projetojpa04.resposta.FilmeSimplesResposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {

    List<Filme> findByDiretor(String diretor);

    List<Filme> findByDiretorAndClassico(String diretor, boolean classico);

    List<Filme> findByDiretorContainsAndClassico(String diretor, boolean classico);

    List<Filme> findByClassicoTrue();

    @Query("select f from Filme f")
    List<FilmeSimplesResposta> findAllSimples();
}
