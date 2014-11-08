package modelo.dao;

import java.sql.*;
import modelo.Agenda;
import sun.security.jca.GetInstance;

public class AgendaDAO implements DAO{
    private Connection conexao;
    
    public AgendaDAO(Connection conn){
        this.conexao = conn;
    }
    
    @Override
    public void inserir(Object object) throws Exception {
        try {
                //Connection conn = new DAOconexao().getConn();  
                Agenda a = (Agenda)object;
                PreparedStatement st;
                st = conexao.prepareStatement("INSERT INTO "+
                "CONTATO (NOME, TELEFONE, CELULAR, EMAIL) VALUES (?, ?, ?, ?)");
                st.setString(1,a.getNome());
                st.setString(2,a.getTelefone());
                st.setString(3,a.getCelular());
                st.setString(4,a.getEmail());
                st.execute();
        } catch (SQLException e) {
                throw new Exception("Erro ao inserir o Contato! \n SQLException: " + 
                e.getMessage());
        }
    }

    @Override
    public void alterar(Object object) throws Exception {
        try {
            Agenda a = (Agenda)object;
            PreparedStatement st = conexao.prepareStatement("UPDATE CONTATO " + 
                "SET NOME = ?, TELEFONE = ?, CELULAR = ?, EMAIL = ?WHERE CODIGO = ?");
            st.setString(1, a.getNome());
            st.setString(2, a.getTelefone());
            st.setString(3, a.getCelular());
            st.setString(4, a.getEmail());
            st.setString(5, String.valueOf((a.getId())));
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Object object) throws Exception {
        try {
            Agenda a = (Agenda)object;
            PreparedStatement st = conexao.prepareStatement("DELETE FROM CONTATO " + 
                "WHERE CODIGO = ?");
            st.setString(1, String.valueOf((a.getId())));
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
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