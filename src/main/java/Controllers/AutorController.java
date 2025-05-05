package Controllers;

import entities.Autors;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AutorController {
    List<Autors> autors;

    public AutorController() {
        autors = new ArrayList<Autors>();
    }

    public List<Autors> getAutors() {
        return autors;
    }

    public void setAutors(List<Autors> autors) {
        this.autors = autors;
    }

    public void cadastrarAutor(Autors autor) {
        autors.add(autor);
    }

    public void excluirAutor(Autors autor) {
        autors.remove(autor);
    }

    public Optional<Autors> getAutor(String nomeAutor) {
        for (Autors autor : autors) {
            if (autor.getNome().equals(nomeAutor)) {
                return Optional.of(autor);
            }
        }
        return Optional.empty();
    }
}
