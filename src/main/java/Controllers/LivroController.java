package Controllers;

import entities.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LivroController {
    private List<Livro> livro;

    public LivroController() {
        this.livro = new ArrayList<Livro>();
    }

    public void adicionarLivro(Livro livro) {
        this.livro.add(livro);
    }

    public Optional<Livro> pesquisarLivroId(int id){
         return this.livro.stream().filter(l -> l.getId() == id).map(l ->{
             Livro livroTemp = (Livro) l;
             return livroTemp;
         }).findFirst();
    }

    public Optional<Livro> pesquisarLivroNome(String nome){
        return this.livro.stream()
                .filter(l -> l.getTitulo().equals(nome))
                .findFirst();
    }

    public List<Livro> pesquisarLivroAutor(String autor){
        return this.livro.stream().filter(l -> l.getAutor().equals(autor)).collect(Collectors.toList());
    }

    /*public Optional<Livro> pesquisarLivroCategoria(String categoria){
        return this.livro.stream().filter(l -> l.get)
    }*/
}
