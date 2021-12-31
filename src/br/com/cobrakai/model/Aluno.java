package br.com.cobrakai.model;

import java.util.Date;

public class Aluno {
    private int id;
    private String nome;
    private int idade;
    private Date cadastro;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public Date getCadastro() {
        return cadastro;
    }
    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }
}
