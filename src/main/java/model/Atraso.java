package model;

import java.time.LocalDate;
import java.time.Period;

public class Atraso extends Devolucao implements Comparable<Atraso> {

    private int diasAtrasados;

    public Atraso(int id, LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao, Usuario usuario, Livro livro,
                  LocalDate dataDevolucao) {
        super(id, dataEmprestimo, dataPrevistaDevolucao, usuario, livro, dataDevolucao);

        if (dataDevolucao.isAfter(dataPrevistaDevolucao)) {
            Period periodo = Period.between(dataPrevistaDevolucao, dataDevolucao);
            this.diasAtrasados = periodo.getDays() + (periodo.getMonths() * 30) + (periodo.getYears() * 365);
        } else {
            this.diasAtrasados = 0;
        }
    }

    public void setDiasAtrasados(int diasAtrasados) {
        this.diasAtrasados = diasAtrasados;
    }

    public int getDiasAtrasados() {
        return diasAtrasados;
    }

    @Override
    public int compareTo(Atraso o) {
        return Integer.compare(this.diasAtrasados, o.getDiasAtrasados());
    }

    @Override
    public String toString() {
        return "\nAtrasos[" +
                "\ndiasAtrasados:" + diasAtrasados +
                "\n] " + super.toString();
    }
}
