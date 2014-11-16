package br.marcelo.tcc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.marcelo.tcc.model.Exame;

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
	   montarSQL.append("from exame e ");
	   if (idPaciente != null && idPaciente > 0){
		   montarSQL.append("jon e.paciente p ");
	   }
	   if (idMedico != null && idMedico > 0){
		   montarSQL.append("jon e.medico m ");
	   }
	   montarSQL.append("where 1 = 1 ");
	   if (idPaciente != null && idPaciente > 0){
		   montarSQL.append("and p.id = "+idPaciente);
	   }
	   if (idMedico != null && idMedico > 0){
		   montarSQL.append("and m.id = "+idMedico);
	   }
	   
	   try {
		   List<Exame> listaExames = (List<Exame>) session.createQuery(montarSQL.toString());
		   return listaExames;
	   }catch (Exception e){
		   return null;
	   }
	}
}
