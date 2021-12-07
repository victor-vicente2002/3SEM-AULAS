public abstract class Educador {

    //Atributos
    private String nome;
    private Integer qtdAulas;
    private Double valorAula;

    //método
    public abstract Double getValorBonus();

    @Override
    public String toString() {
        return "Educador{" +
                "nome='" + nome + '\'' +
                ", qtdAulas=" + qtdAulas +
                ", valorAula=" + valorAula +
                '}';
    }

    //Construtor

    public Educador(String nome, Integer qtdAulas, Double valorAula) {
        this.nome = nome;
        this.qtdAulas = qtdAulas;
        this.valorAula = valorAula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdAulas() {
        return qtdAulas;
    }

    public void setQtdAulas(Integer qtdAulas) {
        this.qtdAulas = qtdAulas;
    }

    public Double getValorAula() {
        return valorAula;
    }

    public void setValorAula(Double valorAula) {
        this.valorAula = valorAula;
    }
}
