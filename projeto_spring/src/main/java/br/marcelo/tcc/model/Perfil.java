package br.marcelo.tcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="perfil",schema="projeto")
public class Perfil {
	@Id
	@SequenceGenerator	(name =	"seqPerfil",sequenceName ="projeto.seq_perfil") 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqPerfil")	
	private Integer id;
	
	@Column	(name="tipo") 
	private Integer tipo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
	
}
