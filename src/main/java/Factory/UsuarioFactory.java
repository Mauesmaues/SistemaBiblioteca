package Factory;

import Controllers.UsuarioController;
import entities.Usuario;

public class UsuarioFactory {
    private UsuarioController usuarioController;

    public UsuarioFactory(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    public void cadastrarUsuario(String nome, String telefone, String endereco, String email) {
        Usuario usuario = new Usuario(nome, telefone, endereco, email);
        usuarioController.adicionarUsuario(usuario);
    }

    public void buscarUsuario(int id) {}
}
