public class Professor implements Bonificaveis{

    //Atributos
    private String nome;
    private Integer qtdAulas;
    private Double valorAula;


    //Métodos

    public Double getValorBonus() {
        Double bonus = qtdAulas * valorAula * 4.5 * 0.15;
        return bonus;
    }

    //Construtor
    public Professor(String nome, Integer qtdAulas, Double valorAula) {
        this.nome = nome;
        this.qtdAulas = qtdAulas;
        this.valorAula = valorAula;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + nome + '\'' +
                ", qtdAulas=" + qtdAulas +
                ", valorAula=" + valorAula +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public Integer getQtdAulas() {
        return qtdAulas;
    }

    public Double getValorAula() {
        return valorAula;
    }

}
