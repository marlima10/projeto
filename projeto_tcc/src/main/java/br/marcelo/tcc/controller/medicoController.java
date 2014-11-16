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

import br.marcelo.tcc.model.Medico;
import br.marcelo.tcc.service.MedicoService;

@Controller
@RequestMapping(value="/medico")
public class medicoController {

	@Autowired
	private MedicoService medicoService;
	
	@RequestMapping(value="/adicionar", method=RequestMethod.GET)
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("/medico/cadastrar");
		return modelAndView;
	}
	
	@RequestMapping(value="/adicionar", method=RequestMethod.POST)
	public ModelAndView adicionar(@ModelAttribute Medico medico) {		
		ModelAndView modelAndView = new ModelAndView("/medico/pesquisar");
		medicoService.adicionar(medico);		
		String mensagem = "Medico Adicionado com sucesso!!!.";
		modelAndView.addObject("message", mensagem);
		//teste
		return modelAndView;
	}
	
	@RequestMapping(value="/editar/{id}", method=RequestMethod.GET)
	public ModelAndView editar(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/medico/editar");
		Medico medico = medicoService.getMedico(id);
		modelAndView.addObject("medico",medico);
		return modelAndView;
	}
	
	@RequestMapping(value="/editar/{id}", method=RequestMethod.POST)
	public ModelAndView salvarEdicao(@ModelAttribute Medico medico, @PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/medico/pesquisar");	
		medicoService.atualizar(medico);	
		String message = "Estratégia editada com sucesso!!!.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deletar(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/medico/pesquisar");
		medicoService.deletar(id);
		String mensagem = "Estratégia deletada com sucesso!!!.";
		modelAndView.addObject("message", mensagem);
		return modelAndView;
	}
	
	@RequestMapping(value="/pesquisar", method=RequestMethod.POST)
	public ModelAndView pesquisar(@RequestParam("txt_nome") String nome) {
		ModelAndView modelAndView = new ModelAndView("/medico/pesquisar");
		List<Medico> listaMedicos = medicoService.buscarMedicos(nome);
		modelAndView.addObject("listaMedicos", listaMedicos);
		return modelAndView;
	}
	
	@RequestMapping(value="/pesquisar", method=RequestMethod.GET)
	public ModelAndView pesquisar() {
		ModelAndView modelAndView = new ModelAndView("/medico/pesquisar");
		return modelAndView;
	}
}
