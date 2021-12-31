package br.com.cobrakai.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    
    //nome do usuário do mysql.
    private static final String USERNAME = "root";
    
    //senha do banco
    private static final String PASSWORD = "ads01000001";
    
    //caminho bando de dados.
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cobrakai";

    //conexão com o banco de dados.

    public static Connection createConnectionToMySQL() throws Exception{
        //faz a classe ser carregada pela jvm
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        return connection;
    }

    public static void main(String[] args) throws Exception {
        //recuperar conexão com o banco de dados
        Connection con = createConnectionToMySQL();

        //testar se a conexão é nula
        if(con!=null){
            System.out.println("Conectado com sucesso");
            con.close();
        }
    }
}
