package br.marcelo.tcc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.marcelo.tcc.model.Exame;
import br.marcelo.tcc.model.Medico;
import br.marcelo.tcc.model.Paciente;

@Repository
public class ExameDAO{

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Exame getExame(int id) {
		Exame exame = (Exame) getCurrentSession().get(Exame.class, id);
		return exame;
	}

	public void cadastrar(Exame exame) {
		getCurrentSession().save(exame);		
	}

	public void deletar(int id) {
		Exame exame = getExame(id);
		if (exame != null){
			getCurrentSession().delete(exame);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Exame> buscarExamePorPaciente(Integer idPaciente,Integer idMedico) {
	   Session session = getCurrentSession(); 
	   
	   StringBuilder montarSQL = new StringBuilder();
	   montarSQL.append("from Exame e ");
	   montarSQL.append("where 1 = 1 ");
	   if (idPaciente != null && idPaciente > 0){
		   montarSQL.append("and e.paciente.id = "+idPaciente);
	   }
	   if (idMedico != null && idMedico > 0){
		   montarSQL.append("and e.medico.id = "+idMedico);
	   }
	   
	   try {
		   List<Exame> listaExames = (List<Exame>) session.createQuery(montarSQL.toString()).list();
		   return listaExames;
	   }catch (Exception e){
		   return null;
	   }
	}
	
	public void atualizar(Exame exame) {
		getCurrentSession().update(exame);
	}

	@SuppressWarnings("unchecked")
	public List<Paciente> buscarPaciente() {
	   Session session = getCurrentSession(); 
		   
	   StringBuilder montarSQL = new StringBuilder();
	   montarSQL.append("from Paciente p ");
	   List<Paciente> listaPacientes = (List<Paciente>) session.createQuery(montarSQL.toString()).list();
	   return listaPacientes;
	}

	@SuppressWarnings("unchecked")
	public List<Medico> buscarMedico() {
	   Session session = getCurrentSession(); 
	   
	   StringBuilder montarSQL = new StringBuilder();
	   montarSQL.append("from Medico m ");
	   List<Medico> listaMedicos = (List<Medico>) session.createQuery(montarSQL.toString()).list();
	   return listaMedicos;
	}

	public Medico getMedico(Integer idMedico) {
		Medico medico = (Medico) getCurrentSession().get(Medico.class, idMedico);
		return medico;
	}

	public Paciente getPaciente(Integer idPaciente) {
		Paciente paciente = (Paciente) getCurrentSession().get(Paciente.class, idPaciente);
		return paciente;
	}
}
