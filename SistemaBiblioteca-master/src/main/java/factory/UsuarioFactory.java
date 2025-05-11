package factory;

import controllers.UsuarioController;
import model.Usuario;

import java.util.Optional;

public final class UsuarioFactory {

    public static Usuario criarUsuario(String nome, String telefone, String endereco, String email) {

        return  new Usuario(nome, telefone, endereco, email);

    }
}
