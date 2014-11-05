package br.com.projeto.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.ListView;

import br.com.projeto.beans.Paciente;

public class PacienteDAO {
	 private Connection conexao;
	 
	 public PacienteDAO(Connection conn){
	        this.conexao = conn;
	    }
	    
	    public void inserir(Object object) throws Exception {
	        try {
	                //Connection conn = new DAOconexao().getConn();  
	                Paciente p = (Paciente)object;
	                PreparedStatement st;
	                st = conexao.prepareStatement("INSERT INTO "+
	                "PROJETO.PACIENTE (id, nome, sexo, rg, endereco, data_de_nascimento, telefone) VALUES (nextval('projeto.seq_paciente'), ?, ?, ?, ?, ?, ?)");
	                st.setString(1,p.getNome());
	                st.setString(2,p.getSexo());
	                st.setString(3,p.getRg());
	                st.setString(4,p.getEndereco());
	                st.setDate(5, new java.sql.Date(System.currentTimeMillis()));
	                st.setString(6,p.getTelefone());
	                
	                st.execute();
	        } catch (SQLException e) {
	                throw new Exception("Erro ao inserir o Paciente! \n SQLException: " + 
	                e.getMessage());
	        }
	    }

	    public void alterar(Object object) throws Exception {
	        try {
	        	Paciente a = (Paciente)object;
	            PreparedStatement st = conexao.prepareStatement("UPDATE CONTATO " + 
	                "SET NOME = ?, TELEFONE = ?, CELULAR = ?, EMAIL = ?WHERE CODIGO = ?");
	            //st.setInt(1, a.getId());
	            //st.setString(5, String.valueOf((a.getId())));
	            st.execute();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void excluir(Object object) throws Exception {
	        try {
	        	Paciente a = (Paciente)object;
	            PreparedStatement st = conexao.prepareStatement("DELETE FROM CONTATO " + 
	                "WHERE CODIGO = ?");
	            st.setString(1, String.valueOf((a.getId())));
	            st.execute();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<Paciente> consultar() throws Exception {
	    	List<Paciente> listaPacientes = new ArrayList<Paciente>();
	        try {
	        	PreparedStatement st = conexao.prepareStatement("SELECT * " + 
	                "FROM PROJETO.PACIENTE WHERE 1 = 1 ");
	            ResultSet rs = st.executeQuery();
	            
	            while (rs.next()) {
	            	Paciente paciente = new Paciente();
	            	paciente.setId(rs.getInt("id"));
	            	paciente.setNome(rs.getString("nome"));
	            	paciente.setEndereco(rs.getString("endereco"));
	            	paciente.setRg(rs.getString("rg"));
	            	paciente.setData_nascimento(rs.getDate("data_de_nascimento"));
	            	paciente.setSexo(rs.getString("sexo"));
	            	paciente.setTelefone(rs.getString("telefone"));
	            	listaPacientes.add(paciente);
				}
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return listaPacientes;
	    }    
	    
	    
	    /*1@ forma
	     
	    public class conexao{
	        public AgendaDAO getAgendaDAO(){
	            new AgendaDAO(getConn());
	        }
	        
	        
	    conexao c= new conexao();
	    AgendaDAO d= new AgendaDAO(c.getConn())
	    d.incluir(Agenda);
	    */
	    
	    /*2@ forma
	    ,conexao.getInstance().getAgendaDAO().incluir(agenda);
	    }*/	
}
