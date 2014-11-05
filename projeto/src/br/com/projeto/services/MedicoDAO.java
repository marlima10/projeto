package br.com.projeto.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.projeto.beans.Medico;

public class MedicoDAO {
    private Connection conexao;
    
    public MedicoDAO(Connection conn){
        this.conexao = conn;
    }
    
    public void inserir(Object object) throws Exception {
        try {
                //Connection conn = new DAOconexao().getConn();  
                Medico a = (Medico)object;
                PreparedStatement st;
                st = conexao.prepareStatement("INSERT INTO "+
                "CONTATO (NOME, TELEFONE, CELULAR, EMAIL) VALUES (?, ?, ?, ?)");
                st.setString(1,a.getNome());
                st.setString(2,a.getTelefone());
                st.execute();
        } catch (SQLException e) {
                throw new Exception("Erro ao inserir o Contato! \n SQLException: " + 
                e.getMessage());
        }
    }

    public void alterar(Object object) throws Exception {
        try {
        	Medico a = (Medico)object;
            PreparedStatement st = conexao.prepareStatement("UPDATE CONTATO " + 
                "SET NOME = ?, TELEFONE = ?, CELULAR = ?, EMAIL = ?WHERE CODIGO = ?");
            st.setString(1, a.getNome());
            st.setString(2, a.getTelefone());
            st.setString(5, String.valueOf((a.getId())));
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(Object object) throws Exception {
        try {
        	Medico a = (Medico)object;
            PreparedStatement st = conexao.prepareStatement("DELETE FROM CONTATO " + 
                "WHERE CODIGO = ?");
            st.setString(1, String.valueOf((a.getId())));
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object consultar(int codigo) throws Exception {
        return null;
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
