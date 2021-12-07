package br.com.bandtec.calculadoracomteste.repositorio;

import br.com.bandtec.calculadoracomteste.dominio.Imposto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImpostoRepository extends JpaRepository<Imposto, Integer> {
}
