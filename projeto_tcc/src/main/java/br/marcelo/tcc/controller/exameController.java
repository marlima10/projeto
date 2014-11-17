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

import br.marcelo.tcc.model.Exame;
import br.marcelo.tcc.model.Medico;
import br.marcelo.tcc.model.Paciente;
import br.marcelo.tcc.service.ExameService;

@Controller
@RequestMapping(value="/exame")
public class exameController {

	@Autowired
	private ExameService exameService;
	
	@RequestMapping(value="/adicionar", method=RequestMethod.GET)
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("/exame/cadastrar");
		modelAndView.addObject("exame", new Exame());
		String paginaTipo = "Cadastro de exame";
		modelAndView.addObject("paginaTipo", paginaTipo);
		List<Paciente> listaPacientes = exameService.listaPacientes();
		modelAndView.addObject("listaPacientes", listaPacientes);
		List<Medico> listaMedicos = exameService.listaMedicos();
		modelAndView.addObject("listaMedicos", listaMedicos);
		return modelAndView;
	}
	
	@RequestMapping(value="/adicionar/", method=RequestMethod.POST)
	public ModelAndView adicionar(@RequestParam("txt_paciente") Integer idPaciente,@RequestParam("txt_medico") Integer idMedico,@RequestParam("txt_observacoes") String observacoes) {		
		ModelAndView modelAndView = new ModelAndView("/exame/pesquisar");
		
		Exame exame = new Exame();
		exame.setMedico(exameService.getMedico(idMedico));
		exame.setPaciente(exameService.getPaciente(idPaciente));
		exame.setObservacoes(observacoes);
		exameService.adicionar(exame);		
		String mensagem = "exame Adicionado com sucesso!!!.";
		
		List<Paciente> listaPacientes = exameService.listaPacientes();
		modelAndView.addObject("listaPacientes", listaPacientes);
		List<Medico> listaMedicos = exameService.listaMedicos();
		modelAndView.addObject("listaMedicos", listaMedicos);		
		modelAndView.addObject("mensagem", mensagem);
		return modelAndView;
	}
	
	@RequestMapping(value="/adicionar/{id}", method=RequestMethod.POST)
	public ModelAndView salvarEdicao(@ModelAttribute Exame exame, @PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/exame/pesquisar");	
		exameService.atualizar(exame);	
		String mensagem = "exame editada com sucesso!!!.";
		modelAndView.addObject("mensagem", mensagem);
		return modelAndView;
	}
		
	@RequestMapping(value="/editar/{id}", method=RequestMethod.GET)
	public ModelAndView editar(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/exame/cadastrar");
		Exame exame = exameService.getExame(id);
		modelAndView.addObject("exame",exame);
		return modelAndView;
	}
	
		
	@RequestMapping(value="/pesquisar", method=RequestMethod.POST)
	public ModelAndView pesquisar(@RequestParam("txt_paciente") Integer idPaciente,@RequestParam("txt_medico") Integer idMedico) {
		ModelAndView modelAndView = new ModelAndView("/exame/pesquisar");
		List<Exame> listaExames = exameService.buscarExame(idPaciente,idMedico);
		modelAndView.addObject("listaExames", listaExames);
		
		List<Paciente> listaPacientes = exameService.listaPacientes();
		modelAndView.addObject("listaPacientes", listaPacientes);
		List<Medico> listaMedicos = exameService.listaMedicos();
		modelAndView.addObject("listaMedicos", listaMedicos);
		return modelAndView;
	}
	
	@RequestMapping(value="/pesquisar", method=RequestMethod.GET)
	public ModelAndView pesquisar() {
		ModelAndView modelAndView = new ModelAndView("/exame/pesquisar");
		List<Paciente> listaPacientes = exameService.listaPacientes();
		modelAndView.addObject("listaPacientes", listaPacientes);
		List<Medico> listaMedicos = exameService.listaMedicos();
		modelAndView.addObject("listaMedicos", listaMedicos);
		return modelAndView;
	}
}
