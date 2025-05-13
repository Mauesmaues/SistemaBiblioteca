package factory;

import model.Atraso;
import model.Livro;
import model.Usuario;
import java.time.LocalDate;

public final class AtrasosFactory {
    
    public static Atraso criarAtrasos(int id, LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao, Usuario usuario, Livro livro, LocalDate dataDevolucao) {
        return new Atraso(id, dataEmprestimo, dataPrevistaDevolucao, usuario, livro, dataDevolucao);
    }
}
