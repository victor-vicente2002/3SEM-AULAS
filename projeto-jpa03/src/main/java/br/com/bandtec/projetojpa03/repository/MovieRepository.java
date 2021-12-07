package br.com.bandtec.projetojpa03.repository;

import br.com.bandtec.projetojpa03.dominio.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
