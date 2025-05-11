package factory;

import controllers.EmprestimoController;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

import java.time.LocalDate;
import java.util.Optional;

public final class EmprestimoFactory {


        public static Optional<Emprestimo> criarEmprestimo(int id, LocalDate dataEmprestimo,
                LocalDate dataPrevistaDevolucao, Usuario usuario, Livro livro) {

            Emprestimo emprestimo = new Emprestimo(id, dataEmprestimo, dataPrevistaDevolucao, usuario, livro);
            return Optional.of(emprestimo);
        }
}
