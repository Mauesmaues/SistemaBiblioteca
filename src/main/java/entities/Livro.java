package entities;

import java.time.LocalDate;
import java.util.List;

public class Livro {
    private String titulo;
    private Autors autor;
    private LocalDate anoDePublicacao;
    private int exemplaresDisponiveis;
    private Categoria categoria;
    private int id = 0;

    public Livro(String titulo, Autors autor, LocalDate anoDePublicacao, int exemplaresDisponiveis, int ultimoId, Categoria categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.exemplaresDisponiveis = exemplaresDisponiveis;
        this.categoria = categoria;
        this.id = ultimoId + 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autors getAutor() {
        return autor;
    }

    public void setAutor(Autors autor) {
        this.autor = autor;
    }

    public LocalDate getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(LocalDate anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    public int getExemplaresDisponiveis() {
        return exemplaresDisponiveis;
    }

    public void setExemplaresDisponiveis(int exemplaresDisponiveis) {
        this.exemplaresDisponiveis = exemplaresDisponiveis;
    }
}
