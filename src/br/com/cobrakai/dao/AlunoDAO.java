package br.com.cobrakai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import br.com.cobrakai.factory.ConnectionFactory;
import br.com.cobrakai.model.Aluno;

public class AlunoDAO {
    //CRUD, C = Create, R = Read, U = Update, D = Delete

    public void save(Aluno aluno){
        String sql = "INSERT INTO alunos(nome, idade, cadastro) VALUES (? ,? ,?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Criar conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            //Criamos uma PreparedStatement para executar query
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            //Adicionar os valores esperados para query
            pstm.setString(1, aluno.getNome());
            pstm.setInt(2, aluno.getIdade());
            pstm.setDate(3, new Date(aluno.getCadastro().getTime()));

            //Executar a query
            pstm.execute();
            System.out.println("Aluno(a) registrado com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            //Fechar as conexões
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
