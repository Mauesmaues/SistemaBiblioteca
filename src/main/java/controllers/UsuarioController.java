package controllers;

import model.Usuario;

import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioController {
    private static List<Usuario> usuarios;

    public UsuarioController() {
        this.usuarios = new ArrayList<>();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void adicionarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public static Optional<Usuario> buscarUsuario(String nome) {
        return usuarios.stream()
                .filter(usuario -> usuario.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }
}
