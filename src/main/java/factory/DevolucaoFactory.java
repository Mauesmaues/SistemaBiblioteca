package factory;

import model.Devolucao;
import model.Livro;
import model.Usuario;

import java.time.LocalDate;
public final class DevolucaoFactory {
   
    public static Devolucao criarDevolucao(int id, LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao, Usuario usuario, Livro livro, LocalDate dataDevolucao) {
        return new Devolucao(id, dataEmprestimo, dataPrevistaDevolucao, usuario, livro, dataDevolucao);
    }
}
