package modelo.dao;

public interface DAO {
    public void inserir(Object object) throws Exception;
    public void alterar(Object object) throws Exception;
    public void excluir(Object object) throws Exception;
    public Object consultar(int codigo) throws Exception;
    
}