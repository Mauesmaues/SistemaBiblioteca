package model;

import enums.StatusEmprestimo;

import java.time.LocalDate;

public class Emprestimo implements Comparable<Emprestimo> {
    private int id;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private Usuario usuario;
    private Livro livro;
    private StatusEmprestimo statusEmprestimo;
    
    public Emprestimo(int id, LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao,
        Usuario usuario, Livro livro) {
        this.id = id;
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevistaDevolucao = dataEmprestimo.plusDays(7);
        this.usuario = usuario;
        this.livro = livro;
        this.statusEmprestimo = StatusEmprestimo.EMPRESTADO;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }


    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }


    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }


    public Usuario getUsuario() {
        return usuario;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public Livro getLivro() {
        return livro;
    }


    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public StatusEmprestimo getStatusEmprestimo() {
        return statusEmprestimo;
    }

    public void setStatusEmprestimo(StatusEmprestimo statusEmprestimo) {
        this.statusEmprestimo = statusEmprestimo;
    }
    
    @Override
    public String toString() {
        return "Emprestimo [id=" + id + ", dataEmprestimo=" + dataEmprestimo + ", dataPrevistaDevolucao=" + dataPrevistaDevolucao +
             ", usuario=" + usuario + ", livro=" + livro
                + "]";
    }    

    @Override
    public int compareTo(Emprestimo o) {
        return this.dataEmprestimo.compareTo(o.dataEmprestimo);
    }

}
