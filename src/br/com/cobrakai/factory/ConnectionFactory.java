package br.com.cobrakai.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    //nome do usuário do mysql.
    private static final String USERNAME = "root";
    
    //senha do banco
    private static final String PASSWORD = "123";
    
    //caminho bando de dados.
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cobrakai";

    //conexão com o banco de dados.

    public static Connection createConnectionToMySQL(){
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException {
        //recuperar conexão com o banco de dados
        Connection con = createConnectionToMySQL();

        //testar se a conexão é nula
        if(con!=null){
            System.out.println("Conectado com sucesso");
            con.close();
        }
    }
}
