package br.com.bandtec.projeto04;

public class Cliente {

    private String nome;
    private Double renda;

    public String getClasseSocial() {
        if (this.renda <= 2900.0){
            return "Pobre";
        }
        else if (this.renda < 12_000.0) {
            return "Classe Média";
        }
        else {
            return "Rico";
        }
    }

    public Cliente(String nome, Double renda) {
        this.nome = nome;
        this.renda = renda;
    }

    public String getNome() {
        return nome;
    }

    public Double getRenda() {
        return renda;
    }
}
