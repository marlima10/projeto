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
import br.marcelo.tcc.model.Usuario;
import br.marcelo.tcc.service.EstrategiaService;
import br.marcelo.tcc.service.UsuarioService;

@Controller
@RequestMapping(value="/sistema")
public class sistemaController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/logar", method=RequestMethod.POST)
	public ModelAndView adicionar(@ModelAttribute Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView();
		Usuario usuarioLogado = null;
		usuarioLogado = usuarioService.buscarUsuario(usuario);
		
		if (usuarioLogado != null && usuarioLogado.getId() > 0){
			modelAndView.setViewName("/login/principal");
			String mensagem = "Bem vindo ao sistema!!!";
			modelAndView.addObject("message", mensagem);
		}else{
			modelAndView.setViewName("/login/home");
			String mensagem = "Usuário não encontrado!!!";
			modelAndView.addObject("message", mensagem);
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/principal")
	public ModelAndView principal() {
		ModelAndView modelAndView = new ModelAndView("/login/principal");
		return modelAndView;
	}
}
