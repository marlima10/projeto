package br.marcelo.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.marcelo.tcc.model.Estrategia;
import br.marcelo.tcc.service.EstrategiaService;

@Controller
@RequestMapping(value="/estrategia")
public class estrategiaController {

	@Autowired
	private EstrategiaService estrategiaService;
	
	@RequestMapping(value="/adicionar", method=RequestMethod.GET)
	public ModelAndView addStrategyPage() {
		ModelAndView modelAndView = new ModelAndView("/estrategia/cadastrar");
		modelAndView.addObject("strategy", new Estrategia());
		return modelAndView;
	}
	
	@RequestMapping(value="/adicionar", method=RequestMethod.POST)
	public ModelAndView adicionar(@ModelAttribute Estrategia estrategia) {
		
		ModelAndView modelAndView = new ModelAndView("/estrategia/cadastrar");
		estrategiaService.adicionar(estrategia);		
		String mensagem = "Estratégia Adicionada com sucesso!!!.";
		modelAndView.addObject("message", mensagem);	
		return modelAndView;
	}
	
	@RequestMapping(value="/pesquisar")
	public ModelAndView pesquisar() {
		ModelAndView modelAndView = new ModelAndView("/estrategia/pesquisar");
		List<Estrategia> listaEstrategia = estrategiaService.getListar() ;
		modelAndView.addObject("listaEstrategia", listaEstrategia);
		return modelAndView;
	}
	
	@RequestMapping(value="/editar/{id}", method=RequestMethod.GET)
	public ModelAndView editar(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/estrategia/editar");
		Estrategia strategy = estrategiaService.getEstrategia(id);
		modelAndView.addObject("strategy",strategy);
		return modelAndView;
	}
	
	@RequestMapping(value="/editar/{id}", method=RequestMethod.POST)
	public ModelAndView salvarEdicao(@ModelAttribute Estrategia estrategia, @PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/estrategia/pesquisar");	
		estrategiaService.atualizar(estrategia);	
		String message = "Estratégia editada com sucesso!!!.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteStrategy(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/estrategia/pesquisar");
		estrategiaService.deletar(id);
		String mensagem = "Estratégia deletada com sucesso!!!.";
		modelAndView.addObject("message", mensagem);
		return modelAndView;
	}

}
