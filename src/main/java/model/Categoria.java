package model;

public class Categoria implements Comparable<Categoria> {

    private String nomeCategoria;
    private String descricaoCategoria;

    public Categoria(String nomeCategoria, String descricaoCategoria) {
        this.nomeCategoria = nomeCategoria;
        this.descricaoCategoria = descricaoCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }

    @Override
    public int compareTo(Categoria o) {
        return this.nomeCategoria.compareTo(o.getNomeCategoria());
    }

    @Override
    public String toString() {
        return "\nCategoria [" +
                "\nnomeCategoria:" + nomeCategoria +
                "\ndescricaoCategoria:" + descricaoCategoria +
                "\n]";
    }

}
