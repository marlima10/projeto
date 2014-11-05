package br.com.projeto.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.projeto.services.ExameDAO;
import br.com.projeto.services.MedicoDAO;
import br.com.projeto.services.MedicoesDAO;
import br.com.projeto.services.PacienteDAO;
import br.com.projeto.services.PerfilDAO;
import br.com.projeto.services.UsuarioDAO;

public class  ConnectionFactory {
	 private static ConnectionFactory instance;
	 private String banco = "jdbc:postgresql://localhost:5432/projeto" ;
	 private String usuario = "postgres";
	 private String senha = "marafa87";
	 private Connection conn;

	private ConnectionFactory() {
	     try {
	    	   Class.forName("org.postgresql.Driver");
	           conn = DriverManager.getConnection(banco, usuario, senha);
	     	} catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	    
	   public static ConnectionFactory getInstance() {
		   	if (instance == null) {
	            instance = new ConnectionFactory();
	        }
	        return instance;
	            
	   }

	    public Connection getConn() {
	           return conn;
	    }   

	    public MedicoDAO getMedicoDAO() {
	        return new MedicoDAO(getConn());
	    }
	    
	    public PacienteDAO getPacienteDAO() {
	        return new PacienteDAO(getConn());
	    }
	    
	    public PerfilDAO getPerfilDAO() {
	        return new PerfilDAO(getConn());
	    }
	    
	    public UsuarioDAO getUsuarioDAO() {
	        return new UsuarioDAO(getConn());
	    }
	    
	    public ExameDAO getExameDAO() {
	        return new ExameDAO(getConn());
	    }
	    
	    public MedicoesDAO getMedicoesDAO() {
	        return new MedicoesDAO(getConn());
	    }
}
