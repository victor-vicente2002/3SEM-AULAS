package br.com.bandtec.projetojpa05;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SportRepository extends JpaRepository<Sport, Integer> {

    List<Sport> findByCategoryId(Integer idCategory);

    @Query("select e from Sport e where e.category.id = ?1")
    List<Sport> getSportByCategoryId(Integer idCategory);

}
