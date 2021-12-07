package br.com.bandtec.projetojpa03.dominio;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @NotEmpty
    @NotBlank
    @Size(min = 2, max = 40)
    @NotNull
    private String name;

//    @PositiveOrZero
    @Positive
    @NotNull
    private Double productionCost;

//    @PastOrPresent
    @Past
    private LocalDate releaseDay;

    @Pattern(regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})")
    private String directorPhone;

    @CPF
    private String directorCpf;

    @CNPJ
    private String productorCnpj;

    public String getDirectorPhone() {
        return directorPhone;
    }

    public void setDirectorPhone(String directorPhone) {
        this.directorPhone = directorPhone;
    }

    public String getDirectorCpf() {
        return directorCpf;
    }

    public void setDirectorCpf(String directorCpf) {
        this.directorCpf = directorCpf;
    }

    public String getProductorCnpj() {
        return productorCnpj;
    }

    public void setProductorCnpj(String productorCnpj) {
        this.productorCnpj = productorCnpj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(Double productionCost) {
        this.productionCost = productionCost;
    }

    public LocalDate getReleaseDay() {
        return releaseDay;
    }

    public void setReleaseDay(LocalDate releaseDay) {
        this.releaseDay = releaseDay;
    }
}
