package model;

import java.time.LocalDate;

public class Devolucao extends Emprestimo {

    private LocalDate dataDevolucao;
    private int diasEmprestados;
    private int id;

    public Devolucao(int id, LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao, Usuario usuario, Livro livro, LocalDate dataDevolucao) {

        super(id, dataEmprestimo, dataPrevistaDevolucao, usuario, livro);
        this.dataDevolucao = dataDevolucao;
        this.diasEmprestados = dataDevolucao.getDayOfYear() - dataEmprestimo.getDayOfYear();
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "Devolucao [\ndataDevolucao=" + dataDevolucao + "\ndiasEmprestados=" + diasEmprestados + "]";
    }
}
