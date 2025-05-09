package controllers;

import model.Autor;
import model.Categoria;
import model.Livro;
import factory.LivroFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LivroController {
    private List<Livro> livro;

    public LivroController() {
        this.livro = new ArrayList<Livro>();
    }

    public String cadastrarLivro(String titulo, String autor, String dataPublicacao, int exemplaresDisponiveis, String categoria) {

        int id = 0;

        Optional<Autor> autorExistente = AutorController.buscarAutor(autor);
        Optional<Categoria> categoriaExistente = CategoriaController.buscarCategoria(categoria);

        if(!this.livro.isEmpty()){ id = this.livro.getLast().getId() + 1; }

        if (autorExistente.isEmpty()) {return "Autor Inexistente";}

        if (categoriaExistente.isEmpty()) {return "Categoria Inexistente";}

        Optional<Livro> livroFac = LivroFactory.criarLivro(titulo, autorExistente.get(), dataPublicacao, exemplaresDisponiveis, categoriaExistente.get(), id);
        if (livroFac.isEmpty()) {return "Não foi possivel cadastrar o livro";}

        this.livro.add(livroFac.get());
        return "Livro cadastrado com sucesso";
    }


    public Optional<Livro> pesquisarLivroId(int id){
         return this.livro.stream().filter(l -> l.getId() == id).findFirst();
    }

    public Optional<Livro> pesquisarLivroNome(String nome){
        return this.livro.stream()
                .filter(l -> l.getTitulo().equals(nome))
                .findFirst();
    }

    public List<Livro> pesquisarLivroAutor(String autor){
        return this.livro.stream().filter(l -> l.getAutor().getNome().equals(autor)).collect(Collectors.toList());
    }

    /*public Optional<Livro> pesquisarLivroCategoria(String categoria){
        return this.livro.stream().filter(l -> l.get)
    }*/
}
