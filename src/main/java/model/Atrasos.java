package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;

public class Atrasos extends Devolucao {

    private int diasAtrasados;

    public Atrasos(int id, LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao, Usuario usuario, Livro livro,
            LocalDate dataDevolucao) {
        super(id, dataEmprestimo, dataPrevistaDevolucao, usuario, livro, dataDevolucao);

        if (dataDevolucao.isAfter(dataPrevistaDevolucao)) {
            Period periodo = Period.between(dataPrevistaDevolucao, dataDevolucao);
            this.diasAtrasados = periodo.getDays() + (periodo.getMonths() * 30) + (periodo.getYears() * 365);
        } else {
            this.diasAtrasados = 0;
        }
    }

    public int getDiasAtrasados() {
        return diasAtrasados;
    }

    public class AtrasosComparator implements Comparator<Atrasos> {

        @Override
        public int compare(Atrasos a1, Atrasos a2) {
            return Integer.compare(a1.getDiasAtrasados(), a2.getDiasAtrasados());
        }

        @Override
        public String toString() {
            return "\nAtrasos [diasAtrasados=" + diasAtrasados
                    + "\n dataEmprestimo=" + getDataEmprestimo()
                    + "\n dataPrevistaDevolucao=" + getDataPrevistaDevolucao()
                    + "\n dataDevolucao=" + getDataDevolucao()
                    + "\n usuario=" + getUsuario()
                    + "\n livro=" + getLivro()
                    + "\n statusEmprestimo=" + getStatusEmprestimo()
                    + "]";
        }
    }
}
