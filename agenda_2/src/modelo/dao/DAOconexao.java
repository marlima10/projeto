package modelo.dao;

import java.sql.*;

public class DAOconexao {
    private static DAOconexao instance;
    private String banco = "jdbc:postgresql://localhost:5432/projeto" ;
    private String usuario = "postgres";
    private String senha = "marafa87";
    private Connection conn;

    private DAOconexao() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(banco, usuario, senha);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
   public static DAOconexao getInstance() {
        if (instance == null) {
            instance = new DAOconexao();
        }
            return instance;
            
   }

    public Connection getConn() {
           return conn;
    }   
    
    public AgendaDAO getAgendaDAO() {
        return new AgendaDAO(getConn());
    }
   
}