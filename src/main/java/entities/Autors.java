package entities;

import enums.StatusAutor;

import java.time.LocalDate;

public class Autors {
    private String nome;
    private LocalDate dataNascimento;
    private String nacionalidade;
    private StatusAutor statusAutor;

    public Autors(String nome, LocalDate dataNascimento, String nacionalidade, StatusAutor statusAutor) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.statusAutor = statusAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public StatusAutor getStatusAutor() {
        return statusAutor;
    }

    public void setStatusAutor(StatusAutor statusAutor) {
        this.statusAutor = statusAutor;
    }
}
