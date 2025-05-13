package model;

import java.time.LocalDate;

public class Devolucao {

    private LocalDate dataDevolucao;
    private int diasEmprestados;
    private int id;
    private LocalDate dataPresvista;
    private LocalDate dataEmprestimo;
    private Usuario usuario;
    private Livro livro;

    public Devolucao(int id, LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao, Usuario usuario, Livro livro, LocalDate dataDevolucao) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPresvista = dataPrevistaDevolucao;
        this.dataDevolucao = dataDevolucao;
        this.diasEmprestados = dataDevolucao.getDayOfYear() - dataEmprestimo.getDayOfYear();
        this.usuario = usuario;
        this.livro = livro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public int getDiasEmprestados() {
        return diasEmprestados;
    }

    public void setDiasEmprestados(int diasEmprestados) {
        this.diasEmprestados = diasEmprestados;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataPresvista() {
        return dataPresvista;
    }

    public void setDataPresvista(LocalDate dataPresvista) {
        this.dataPresvista = dataPresvista;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "\nDevolucao[" +
                "\ndataDevolucao:" + dataDevolucao +
                "\ndiasEmprestados:" + diasEmprestados +
                "\nid:" + id +
                "\ndataPresvista:" + dataPresvista +
                "\ndataEmprestimo:" + dataEmprestimo +
                "\nusuario:" + usuario +
                "\nlivro:" + livro +
                "\n]";
    }
}
