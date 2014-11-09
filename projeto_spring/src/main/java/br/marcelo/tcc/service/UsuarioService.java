package br.marcelo.tcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.marcelo.tcc.dao.EstrategiaDAO;
import br.marcelo.tcc.dao.UsuarioDAO;
import br.marcelo.tcc.model.Estrategia;
import br.marcelo.tcc.model.Usuario;

@Service
@Transactional
public class UsuarioService{

	@Autowired
	private UsuarioDAO usuarioDAO;

	public Usuario getUsuario(int id) {
		return usuarioDAO.getUsuario(id);
	}

	public void deletar(int id) {
		usuarioDAO.deletar(id);
	}

	public void adicionar(Usuario usuario) {
		usuarioDAO.cadastrar(usuario);
	}

	public Usuario buscarUsuario(Usuario usuario){
		return usuarioDAO.buscarUsuario(usuario.getEmail(), usuario.getSenha());
	}
}
