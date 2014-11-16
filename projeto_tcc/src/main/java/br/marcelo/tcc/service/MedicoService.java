package br.marcelo.tcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.marcelo.tcc.dao.MedicoDAO;
import br.marcelo.tcc.model.Medico;

@Service
@Transactional
public class MedicoService{

	@Autowired
	private MedicoDAO medicoDAO;

	public Medico getMedico(int id) {
		return medicoDAO.getMedico(id);
	}

	public void deletar(int id) {
		medicoDAO.deletar(id);
	}

	public void adicionar(Medico medico) {
		medicoDAO.cadastrar(medico);
	}

	public List<Medico> buscarMedicos(String nome){
		List<Medico> listaMedicos = (List<Medico>) medicoDAO.buscarMedico(nome);
		return listaMedicos;
	}

	public void atualizar(Medico medico) {
		medicoDAO.atualizar(medico);
	}
}
