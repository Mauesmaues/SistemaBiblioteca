package controllers;

import factory.UsuarioFactory;
import model.Usuario;

import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsuarioController {
    private static List<Usuario> usuarios;

    public UsuarioController() {
        this.usuarios = new ArrayList<>();
    }

    public String cadastrarUsuario(String nome, String telefone, String endereco, String email) {

        if(nome.isEmpty()){return "Campo nome em branco"; }
        if(telefone.isEmpty()){return "Campo telefone em branco"; }
        if(endereco.isEmpty()){return "Campo endereco em branco"; }
        if(email.isEmpty()){return "Campo email em branco"; }

        Usuario usuario = UsuarioFactory.criarUsuario(nome, telefone, endereco, email);
        this.usuarios.add(usuario);
        return "Usuario cadastrado com sucesso";
    }

    public String excluirUsuario(String nome){
        if(nome.isEmpty()){return "Campo nome em branco"; }
        if(buscarUsuario(nome).isEmpty()){return "Usuario nao encontrado";}

        this.usuarios.remove(buscarUsuario(nome).get());
        return "Usuario excluido com sucesso";
    }

    public String alterarUsuario(String nome, String novoNome, String telefone, String endereco, String email) {
        if(nome.isEmpty()){return "Campo nome em branco"; }
        if(novoNome.isEmpty()){return "Campo novo nome em branco"; }
        if(telefone.isEmpty()){return "Campo telefone em branco"; }
        if(endereco.isEmpty()){return "Campo endereco em branco"; }
        if(email.isEmpty()){return "Campo email em branco"; }
        if(buscarUsuario(nome).isEmpty()){return "Usuario nao encontrado!";}

        buscarUsuario(nome).ifPresent(usuario -> {
            usuario.setNome(novoNome);
            usuario.setTelefone(telefone);
            usuario.setEndereco(endereco);
            usuario.setEmail(email);
        });

        return "Usuario alterado com sucesso!";
    }

    public void ordenarUsuario(){ Collections.sort(usuarios);}

    public List<String> listarUsuarios(){
        return usuarios.stream().map(Usuario::getNome).toList();
    }

    public static Optional<Usuario> buscarUsuario(String nome) {
        return usuarios.stream()
                .filter(usuario -> usuario.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }
}
