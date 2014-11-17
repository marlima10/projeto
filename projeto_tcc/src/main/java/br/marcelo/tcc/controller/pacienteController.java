package br.marcelo.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.marcelo.tcc.model.Paciente;
import br.marcelo.tcc.service.PacienteService;

@Controller
@RequestMapping(value="/paciente")
public class pacienteController {

	@Autowired
	private PacienteService pacienteService;
	
	@RequestMapping(value="/adicionar", method=RequestMethod.GET)
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("/paciente/cadastrar");
		modelAndView.addObject("paciente", new Paciente());
		String paginaTipo = "Cadastro de Paciente";
		modelAndView.addObject("paginaTipo", paginaTipo);
		return modelAndView;
	}
	
	@RequestMapping(value="/adicionar/", method=RequestMethod.POST)
	public ModelAndView adicionar(@ModelAttribute Paciente paciente) {		
		ModelAndView modelAndView = new ModelAndView("/paciente/pesquisar");
		pacienteService.adicionar(paciente);		
		String mensagem = "Paciente Adicionado com sucesso!!!.";
		modelAndView.addObject("mensagem", mensagem);
		return modelAndView;
	}
	
	@RequestMapping(value="/adicionar/{id}", method=RequestMethod.POST)
	public ModelAndView salvarEdicao(@ModelAttribute Paciente paciente, @PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/paciente/pesquisar");	
		pacienteService.atualizar(paciente);	
		String mensagem = "Paciente editada com sucesso!!!.";
		modelAndView.addObject("mensagem", mensagem);
		return modelAndView;
	}
		
	@RequestMapping(value="/editar/{id}", method=RequestMethod.GET)
	public ModelAndView editar(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/paciente/cadastrar");
		Paciente paciente = pacienteService.getPaciente(id);
		modelAndView.addObject("paciente",paciente);
		return modelAndView;
	}
	
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deletar(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/paciente/pesquisar");
		pacienteService.deletar(id);
		String mensagem = "Paciente deletado com sucesso!!!.";
		modelAndView.addObject("message", mensagem);
		return modelAndView;
	}
	
	@RequestMapping(value="/pesquisar", method=RequestMethod.POST)
	public ModelAndView pesquisar(@RequestParam("txt_nome") String nome) {
		ModelAndView modelAndView = new ModelAndView("/paciente/pesquisar");
		List<Paciente> listaPacientes = pacienteService.buscarPacientes(nome);
		modelAndView.addObject("listaPacientes", listaPacientes);
		return modelAndView;
	}
	
	@RequestMapping(value="/pesquisar", method=RequestMethod.GET)
	public ModelAndView pesquisar() {
		ModelAndView modelAndView = new ModelAndView("/paciente/pesquisar");
		return modelAndView;
	}
}
