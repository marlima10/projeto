package br.marcelo.tcc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.marcelo.tcc.model.Estrategia;

@Repository
public class EstrategiaDAO{

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Estrategia getEstrategia(int id) {
		Estrategia estrategia = (Estrategia) getCurrentSession().get(Estrategia.class, id);
		return estrategia;
	}

	public void cadastrar(Estrategia estrategia) {
		getCurrentSession().save(estrategia);		
	}

	public void editar(Estrategia estrategia) {
		Estrategia estrategiaParaAtualizar = getEstrategia(estrategia.getId());
		estrategiaParaAtualizar.setName(estrategia.getName());
		estrategiaParaAtualizar.setType(estrategia.getType());
		getCurrentSession().update(estrategiaParaAtualizar);
	}

	public void deletar(int id) {
		Estrategia estrategia = getEstrategia(id);
		if (estrategia != null)
			getCurrentSession().delete(estrategia);
	}

	@SuppressWarnings("unchecked")
	public List<Estrategia> getListar() {
		return getCurrentSession().createQuery("from Estrategia ").list();
	}
}
