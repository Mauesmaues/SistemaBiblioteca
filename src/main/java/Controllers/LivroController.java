package Controllers;

import entities.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
}
