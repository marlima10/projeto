package br.marcelo.tcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.marcelo.tcc.dao.ExameDAO;
import br.marcelo.tcc.model.Exame;

@Service
@Transactional
public class ExameService{

	@Autowired
	private ExameDAO exameDAO;

	public Exame getExame(int id) {
		return exameDAO.getExame(id);
	}

	public void deletar(int id) {
		exameDAO.deletar(id);
	}

	public void adicionar(Exame exame) {
		exameDAO.cadastrar(exame);
	}

	public List<Exame> buscarUsuario(Integer idPaciente, Integer idMedico){
		List<Exame> listaExanes = exameDAO.buscarExamePorPaciente(idPaciente, idMedico);
		return listaExanes;
	}
}
