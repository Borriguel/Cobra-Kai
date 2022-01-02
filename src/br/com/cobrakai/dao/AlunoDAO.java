package br.com.cobrakai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    public List<Aluno> getAll() {
        String sql = "SELECT * FROM alunos";
        List<Aluno> alunos = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstm = null;
        //Classe que vai recuperar os dados do banco.
        ResultSet rst = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rst = pstm.executeQuery();
            while(rst.next()){
                Aluno aluno = new Aluno();
                aluno.setId(rst.getInt("id"));
                aluno.setNome(rst.getString("nome"));
                aluno.setIdade(rst.getInt("idade"));
                aluno.setCadastro(rst.getDate("cadastro"));

                alunos.add(aluno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
                if(rst!=null){
                    rst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return alunos;
    }

    public void deleteByID(Integer id){
        String sql = "DELETE FROM alunos WHERE id = ?";
        Connection conn= null;
        PreparedStatement pstm = null;
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
            System.out.println("Aluno(a) de Id " + id + " deletado com sucesso.");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
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

