package br.marcelo.tcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="usuario",schema="projeto")
public class Usuario {
	@Id
	@SequenceGenerator	(name =	"seqUsuario",sequenceName ="projeto.seq_usuario") 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqUsuario")	
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="id_perfil")
	private Perfil perfil;
	
	@Column	(name="email") 
    private String email;
	
	@Column	(name="senha") 
    private String senha;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}  
       
}