package br.com.bandtec.projetojpa03.repository;

import br.com.bandtec.projetojpa03.dominio.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
