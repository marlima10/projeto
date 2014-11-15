package br.marcelo.tcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.marcelo.tcc.dao.EstrategiaDAO;
import br.marcelo.tcc.model.Estrategia;

@Service
@Transactional
public class EstrategiaService{

	@Autowired
	private EstrategiaDAO estrategiaDAO;

	public Estrategia getEstrategia(int id) {
		return estrategiaDAO.getEstrategia(id);
	}

	public void deletar(int id) {
		estrategiaDAO.deletar(id);
	}

	public void adicionar(Object object) {
		Estrategia estrategia = (Estrategia) object;
		estrategiaDAO.cadastrar(estrategia);
	}

	public void atualizar(Estrategia estrategia) {
		estrategiaDAO.editar(estrategia);
	}

	public List<Estrategia> getListar() {
		return  estrategiaDAO.getListar();
	}

}
