package br.com.cobrakai.application;

import java.util.Date;

import br.com.cobrakai.dao.AlunoDAO;
import br.com.cobrakai.model.Aluno;

public class App {
    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno aluno = new Aluno();
        aluno.setNome("Daniel San");
        aluno.setIdade(55);
        aluno.setCadastro(new Date());
        alunoDAO.save(aluno);
    }
}
