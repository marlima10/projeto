package br.marcelo.tcc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.marcelo.tcc.model.Paciente;

@Repository
public class PacienteDAO{

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Paciente getPaciente(int id) {
		Paciente paciente = (Paciente) getCurrentSession().get(Paciente.class, id);
		return paciente;
	}

	public void cadastrar(Paciente paciente) {
		getCurrentSession().save(paciente);		
	}

	public void deletar(int id) {
		Paciente paciente = getPaciente(id);
		if (paciente != null)
			getCurrentSession().delete(paciente);
	}

	@SuppressWarnings("unchecked")
	public List<Paciente> buscarPaciente(String nome) {
		   Session session = getCurrentSession(); 
		   
		   StringBuilder montarSQL = new StringBuilder();
		   montarSQL.append("from paciente p ");
		   montarSQL.append("where 1 = 1 ");
		   if(nome != null && !nome.trim().equals("")){
			   montarSQL.append("and p.nome = '"+nome+"' ");
		   }
		   try {
			   List<Paciente> listaPacientes = (List<Paciente>) session.createQuery(montarSQL.toString());
			   return listaPacientes;
		   }catch (Exception e){
			   return null;
		   }	   
	}
}
