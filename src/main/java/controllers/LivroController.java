package controllers;

import model.Autor;
import model.Categoria;
import model.Livro;
import factory.LivroFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LivroController {

    private static List<Livro> livros;

    public LivroController() {
        this.livros = new ArrayList<Livro>();
    }

    public String cadastrarLivro(String titulo, String autor, String dataPublicacao, int exemplaresDisponiveis, String categoria) {

        int id = 0;

        if (!livros.isEmpty()) { id = livros.getLast().getId() + 1; }

        Optional<Autor> autorExistente = AutorController.buscarAutor(autor);
        Optional<Categoria> categoriaExistente = CategoriaController.buscarCategoria(categoria);
        LocalDate data = LocalDate.parse(dataPublicacao, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (autorExistente.isEmpty()) { return "Autor Inexistente!"; }
        if (categoriaExistente.isEmpty()) { return "Categoria Inexistente!"; }
        if (titulo.isEmpty()) { return "Titulo em branco!"; }
        if (exemplaresDisponiveis <= 0) { return "Numero de exemplares em branco ou invalido!"; }

        Livro livro = LivroFactory.criarLivro(titulo, autorExistente.get(), data, exemplaresDisponiveis, categoriaExistente.get(), id);

        livros.add(livro);
        return "Livro cadastrado com sucesso";
    }

    public String alterarLivro(String titulo, String novoTitulo, String autor, String dataPublicacao, int exemplaresDisponiveis, String categoria) {

        if (AutorController.buscarAutor(autor).isEmpty()) {return "Autor Inexistente!";}
        if (CategoriaController.buscarCategoria(categoria).isEmpty()) {return "Categoria Inexistente!";}
        if (pesquisarLivroNome(titulo).isEmpty()) {return "Livro não encontrado!";}
        if (novoTitulo.isEmpty()) {return "Campo novo titulo em branco!";}
        if (dataPublicacao.isEmpty()) {return "Campo data em branco!";}
        if (exemplaresDisponiveis <= 0) {return "Exemplares em branco ou invalido!";}

        pesquisarLivroNome(titulo).ifPresent(livro -> {
            livro.setTitulo(novoTitulo);
            livro.setAutor(AutorController.buscarAutor(autor).get());
            livro.setAnoDePublicacao(LocalDate.parse(dataPublicacao, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            livro.setExemplaresDisponiveis(exemplaresDisponiveis);
            livro.setCategoria(CategoriaController.buscarCategoria(categoria).get());
        });

        return "Livro alterado com sucesso!";
    }

    public String excluirLivro(String titulo) {

        if (pesquisarLivroNome(titulo).isEmpty()) {return "Livro inexistente!";}

        livros.remove(pesquisarLivroNome(titulo).get());
        return "Livro excluido com sucesso!";
    }

    public List<String> listarLivros() {
        return livros.stream().map(Livro::getTitulo).toList();
    }

    public void ordenarLivros() {
        Collections.sort(livros);
    }

    public Optional<Livro> pesquisarLivroId(int id) {
        return livros.stream()
                .filter(l -> l.getId() == id).findFirst();
    }

    public static Optional<Livro> pesquisarLivroNome(String titulo) {
        return livros.stream()
                .filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
                .findFirst();
    }

    public List<Livro> pesquisarLivrosAutor(String autor) {
        return livros.stream()
                .filter(l -> l.getAutor().getNome().equalsIgnoreCase(autor)).toList();
    }

}
