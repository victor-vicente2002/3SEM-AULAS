public class Coordenador extends Educador{
    public Coordenador(String nome, Integer qtdAulas, Double valorAula) {
        super(nome, qtdAulas, valorAula);
    }

    //Atributos
    private Integer horasCoordenacao;
    private Double valorCoordenacao;

    //Métodos

    @Override
    public Double getValorBonus() {
        Double bonus = (getQtdAulas() * getValorAula() * 4.5 * 0.15) +
                horasCoordenacao * valorCoordenacao * 4.5 * 0.2;
        return bonus;
    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "horasCoordenacao=" + horasCoordenacao +
                ", valorCoordenacao=" + valorCoordenacao +
                "valorBonus= " + getValorBonus() + " " +
                "} " + super.toString();
    }

    //Construtor

    public Coordenador(String nome, Integer qtdAulas, Double valorAula, Integer horasCoordenacao, Double valorCoordenacao) {
        super(nome, qtdAulas, valorAula);
        this.horasCoordenacao = horasCoordenacao;
        this.valorCoordenacao = valorCoordenacao;
    }
}
