package factory;

import model.Atrasos;
import model.Livro;
import model.Usuario;
import java.time.LocalDate;

public class AtrasosFactory {
    
    public static Atrasos criarAtrasos(int id, LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao, Usuario usuario, Livro livro, LocalDate dataDevolucao) {
        return new Atrasos(id, dataEmprestimo, dataPrevistaDevolucao, usuario, livro, dataDevolucao);
    }
}
