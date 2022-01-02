package br.com.cobrakai.application;

import java.util.Date;

import br.com.cobrakai.dao.AlunoDAO;
import br.com.cobrakai.model.Aluno;

public class App {
    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno aluno = new Aluno();
        aluno.setNome("Johnny Lawrence");
        aluno.setIdade(56);
        aluno.setCadastro(new Date());
        alunoDAO.save(aluno);
        //teste 1
        for (Aluno x : alunoDAO.getAll()) {
            System.out.println("Id - " +x.getId() + " | Nome - " + x.getNome() + " | Idade - "+ x.getIdade() + " | Data do Cadastro - " + x.getCadastro());
        }
        //teste deleteById()
        alunoDAO.deleteByID(5);
        for (Aluno x : alunoDAO.getAll()) {
            System.out.println("Id - " +x.getId() + " | Nome - " + x.getNome() + " | Idade - "+ x.getIdade() + " | Data do Cadastro - " + x.getCadastro());
        }

    }
}
