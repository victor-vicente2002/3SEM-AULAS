package br.com.bandtec.projetojpa05;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EsporteRepository extends JpaRepository<Esporte, Integer> {

    List<Esporte> findByTipoId(Integer idTipo);

    List<Esporte> findByTipoNome(String nomeTipo);

    // este faz o mesmo que o findByTipoId(), porém com Query
    @Query("select e from Esporte e where e.tipo.id = ?1")
    List<EsporteSimplesResposta> pesquisarPorTipo(Integer idTipo);
    // no JPQL podemos parametrizar a consulta, como no exemplo acima, onde temos os parâmetros com X?
    // X começa do 1 (sim, do 1, não do 0)
    // no exemplo acima, o ?1 será substituído pelo parâmetro "idTipo", pois "idTipo" é o 1º parâmetro do método
}
