package br.com.bandtec.projetojpa05;

public class EsporteSimplesResposta {

    private String nomeEsporte;
    private String nomeTipo;

    public EsporteSimplesResposta(Esporte entidade) {
        this.nomeEsporte = entidade.getNome();
        this.nomeTipo = entidade.getTipo().getNome();
    }

    public String getNomeEsporte() {
        return nomeEsporte;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }
}
