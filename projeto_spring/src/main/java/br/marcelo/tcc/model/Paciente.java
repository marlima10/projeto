package br.marcelo.tcc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="paciente",schema="projeto")
public class Paciente {
	@Id
	@SequenceGenerator	(name =	"seqPaciente",sequenceName ="projeto.seq_paciente") 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqPaciente")	
	private Integer id;
	
	@Column	(name="nome") 
	private String nome;
	
	@Column	(name="sexo") 
	private String sexo;
	
	@Column	(name="rg") 
	private String rg;
	
	@Column	(name="data_de_nascimento") 
    private Date data_nascimento; 
    
	@Column	(name="telefone") 
    private String telefone;
	
	@Column	(name="endereco") 
    private String endereco;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Date getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	} 
}
