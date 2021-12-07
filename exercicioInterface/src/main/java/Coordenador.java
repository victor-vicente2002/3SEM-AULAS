import java.util.function.DoublePredicate;

public class Coordenador implements Bonificaveis{

    //Atributos
    private String nome;
    private Integer qtdHoras;
    private Double valorHora;

    //Métodos
    @Override
    public Double getValorBonus() {
        Double bonus = qtdHoras * valorHora * 4.5 * 0.2;
        return bonus;
    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "nome=" + nome +
                ", qtdHoras=" + qtdHoras +
                ", valorHora=" + valorHora +
                '}';
    }

    //Construtor
    public Coordenador(String nome, Integer qtdHoras, Double valorHora) {
        this.nome = nome;
        this.qtdHoras = qtdHoras;
        this.valorHora = valorHora;
    }



    public String getNome() {
        return nome;
    }

    public Integer getQtdHoras() {
        return qtdHoras;
    }

    public Double getValorHora() {
        return valorHora;
    }

}
