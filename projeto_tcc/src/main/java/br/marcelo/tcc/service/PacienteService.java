package br.marcelo.tcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.marcelo.tcc.dao.PacienteDAO;
import br.marcelo.tcc.model.Paciente;

@Service
@Transactional
public class PacienteService{

	@Autowired
	private PacienteDAO pacienteDAO;

	public Paciente getPaciente(int id) {
		return pacienteDAO.getPaciente(id);
	}

	public void deletar(int id) {
		pacienteDAO.deletar(id);
	}

	public void adicionar(Paciente paciente) {
		pacienteDAO.cadastrar(paciente);
	}

	public List<Paciente> buscarPacientes(String nome){
		List<Paciente> listaPacientes = (List<Paciente>) pacienteDAO.buscarPaciente(nome);
		return listaPacientes;
	}
}
