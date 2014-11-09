package br.marcelo.tcc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.marcelo.tcc.model.Usuario;

@Repository
public class UsuarioDAO{

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Usuario getUsuario(int id) {
		Usuario Usuario = (Usuario) getCurrentSession().get(Usuario.class, id);
		return Usuario;
	}

	public void cadastrar(Usuario Usuario) {
		getCurrentSession().save(Usuario);		
	}

	public void deletar(int id) {
		Usuario Usuario = getUsuario(id);
		if (Usuario != null)
			getCurrentSession().delete(Usuario);
	}

	public Usuario buscarUsuario(String email,String senha) {
	   Session session = getCurrentSession(); 
	   
	   StringBuilder montarSQL = new StringBuilder();
	   montarSQL.append("from Usuario u ");
	   montarSQL.append("where 1 = 1 ");
	   montarSQL.append("and u.email = '"+email+"' ");
	   montarSQL.append("and u.senha = '"+senha+"' ");
	   
	   try {
		   Usuario usuario = (Usuario) session.createQuery(montarSQL.toString()).iterate().next();
		   return usuario;
	   }catch (Exception e){
		   return null;
	   }
	   
	}
}
