public class Alimento extends Produto{

    //Atributo
    private Integer qtdVitamina;

    //Construtor


    public Alimento(Integer codigo, String descricao, Double preco, Integer qtdVitamina) {
        super(codigo, descricao, preco);
        this.qtdVitamina = qtdVitamina;
    }

    //Métodos


    public Double getValorTributo() {
        return getPreco() * 0.15;
    }

    @Override
    public String toString() {
        return "Alimento{" +
                "qtdVitamina=" + qtdVitamina +
                ", tributo= " + getValorTributo() +
                "} " + super.toString();
    }
}
