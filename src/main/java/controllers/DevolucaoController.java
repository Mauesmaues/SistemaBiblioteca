package controllers;

import model.Devolucao;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLEditorKit.LinkController;

import enums.StatusEmprestimo;
import factory.DevolucaoFactory;
import factory.AtrasosFactory;

public class DevolucaoController {
    private static List<Devolucao> devolucoes;

    public DevolucaoController() {
        this.devolucoes = new ArrayList<Devolucao>();
    }

    public String registrarDevolucao(String usuario, String dataDevolucao) {
        LocalDate data = LocalDate.parse(dataDevolucao, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        int id = 0;

        if (!devolucoes.isEmpty()) { id = devolucoes.getLast().getId() + 1;}
        if (EmprestimoController.buscarEmprestimoUser(usuario).get().getDataEmprestimo().isAfter(data)) {
            return "Devolucao não pode ser registrada antes da data de Emprestimo!";
        }
        if (EmprestimoController.buscarEmprestimoUser(usuario).isEmpty()) { return "Emprestimo não encontrado!";}


        Usuario usuarioDevolucao = UsuarioController.buscarUsuario(usuario).get();
        Livro livroDevolucao = EmprestimoController.buscarEmprestimoUser(usuario).get().getLivro(); 
        LivroController.pesquisarLivroNome(livroDevolucao.getTitulo()).get().setExemplaresDisponiveis(livroDevolucao.getExemplaresDisponiveis() + 1);
        LocalDate dataEmprestimo = EmprestimoController.buscarEmprestimoUser(usuario).get().getDataEmprestimo();
        LocalDate dataPrevistaDevolucao = EmprestimoController.buscarEmprestimoUser(usuario).get().getDataPrevistaDevolucao();

        if (dataPrevistaDevolucao.isBefore(data)) {
            AtrasosController.cadastrarAtraso(id, dataEmprestimo, dataPrevistaDevolucao, usuarioDevolucao, livroDevolucao, data);
        }

        Devolucao devolucao = DevolucaoFactory.criarDevolucao(id, dataEmprestimo, dataPrevistaDevolucao, usuarioDevolucao, livroDevolucao, data);
        EmprestimoController.buscarEmprestimoUser(usuario).get().setStatusEmprestimo(StatusEmprestimo.valueOf("DEVOLVIDO"));
        this.devolucoes.add(devolucao);
        return "Devolucao criada com sucesso!";
    }

    public List<Devolucao> listarDevolucaos() {
        return this.devolucoes;
    }
}