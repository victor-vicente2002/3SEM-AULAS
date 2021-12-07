public class Professor extends Educador{
    //Construtor
    public Professor(String nome, Integer qtdAulas, Double valorAula) {
        super(nome, qtdAulas, valorAula);
    }

    //Métodos

    @Override
    public Double getValorBonus() {
        Double bonus = getQtdAulas() * getValorAula() * 4.5 * 0.15;
        return bonus;
    }

    @Override
    public String toString() {
        return "Professor: " +
                "ValorBonus= " + getValorBonus() + " " +
                super.toString();
    }
}
