package br.marcelo.tcc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.marcelo.tcc.model.Medico;

@Repository
public class MedicoDAO{

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Medico getMedico(int id) {
		Medico medico = (Medico) getCurrentSession().get(Medico.class, id);
		return medico;
	}

	public void cadastrar(Medico medico) {
		getCurrentSession().save(medico);		
	}

	public void deletar(int id) {
		Medico medico = getMedico(id);
		if (medico != null)
			getCurrentSession().delete(medico);
	}

	@SuppressWarnings("unchecked")
	public List<Medico> buscarMedico(String nome) {
	   Session session = getCurrentSession(); 
	   
	   StringBuilder montarSQL = new StringBuilder();
	   montarSQL.append("from Medico m ");
	   montarSQL.append("where 1 = 1 ");
	   if(nome != null && !nome.trim().equals("")){
		   montarSQL.append("and m.nome like '%"+nome+"%' ");
	   }
	   try {
		   List<Medico> listaMedicos = (List<Medico>) session.createQuery(montarSQL.toString()).list();
		   return listaMedicos;
	   }catch (Exception e){
		   return null;
	   }
	   
	}

	public void atualizar(Medico medico) {
		getCurrentSession().update(medico);
	}
}
