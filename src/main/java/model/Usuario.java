package model;

import java.time.LocalDate;

public class Usuario implements Comparable<Usuario> {

    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private LocalDate dataCadastro;

    public Usuario(String nome, String telefone, String endereco, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataCadastro = LocalDate.now();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(Usuario o) {
        return this.nome.compareTo(o.getNome());
    }

    @Override
    public String toString() {
        return "Usuario [nome=" + nome + "\ntelefone=" + telefone + "\nendereco=" + endereco + "\nemail=" + email
                + "\ndataCadastro=" + dataCadastro + "]";
    }
}
