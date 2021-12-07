package br.com.bandtec.projetojpa04.resposta;

import br.com.bandtec.projetojpa04.dominio.Filme;

public class FilmeSimplesResposta {

    private String titulo;

    private int anoLancamento;

    public FilmeSimplesResposta(Filme filme) {
        this.titulo = filme.getTitulo();
        this.anoLancamento = filme.getDataLancamento().getYear();
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }
}
