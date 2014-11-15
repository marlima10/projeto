package br.marcelo.tcc.model;

import javax.persistence.*;

@Entity
@Table(name="exame",schema="projeto")
public class Exame {
	@Id
	@SequenceGenerator	(name =	"seqExame",sequenceName ="projeto.seq_exame") 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqExame")	
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_medico")
	private Medico medico;
	
	@Column	(name="observacoes") 
	private String Observacoes;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public String getObservacoes() {
		return Observacoes;
	}
	public void setObservacoes(String observacoes) {
		Observacoes = observacoes;
	}
}
