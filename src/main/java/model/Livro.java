package model;

import java.time.LocalDate;

public class Livro implements Comparable<Livro> {

    private String titulo;
    private Autor autor;
    private LocalDate anoDePublicacao;
    private int exemplaresDisponiveis;
    private Categoria categoria;
    private int id;

    public Livro(String titulo, Autor autor, LocalDate anoDePublicacao, int exemplaresDisponiveis, int ultimoId, Categoria categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.exemplaresDisponiveis = exemplaresDisponiveis;
        this.categoria = categoria;
        this.id = ultimoId;
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int compareTo(Livro o) {
        return this.titulo.compareTo(o.titulo);
    }

    @Override
    public String toString() {
        return "Livro [titulo=" + titulo + "\nautor=" + autor + "\nanoDePublicacao=" + anoDePublicacao
                + "\nexemplaresDisponiveis=" + exemplaresDisponiveis + "\ncategoria=" + categoria + "\nid=" + id + "]";
    }
}
