package br.marcelo.tcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.marcelo.tcc.dao.ExameDAO;
import br.marcelo.tcc.model.Exame;
import br.marcelo.tcc.model.Medico;
import br.marcelo.tcc.model.Paciente;

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

	public List<Exame> buscarExame(Integer idPaciente, Integer idMedico){
		List<Exame> listaExanes = exameDAO.buscarExamePorPaciente(idPaciente, idMedico);
		return listaExanes;
	}
	
	public List<Paciente>listaPacientes(){
		List<Paciente> listaPacientes = exameDAO.buscarPaciente();
		return listaPacientes;
	}
	
	public List<Medico> listaMedicos(){
		List<Medico> listaMedicos = exameDAO.buscarMedico();
		return listaMedicos;
	}
	
	public void atualizar(Exame exame) {
		exameDAO.atualizar(exame);
	}

	public Medico getMedico(Integer idMedico) {
		return exameDAO.getMedico(idMedico);
	}

	public Paciente getPaciente(Integer idPaciente) {
		return exameDAO.getPaciente(idPaciente);
	}
	
	
}
