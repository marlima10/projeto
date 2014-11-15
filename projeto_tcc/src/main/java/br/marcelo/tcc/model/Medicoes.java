package br.marcelo.tcc.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="medicoes",schema="projeto")
public class Medicoes {
	@Id
	@SequenceGenerator	(name =	"seqMedicoes",sequenceName ="projeto.seq_medicoes") 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqMedicoes")	
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_exame")
	private Exame exame;
	
	@Column	(name="pressao_sistolica") 
	private Integer pressao_sistolica;
	
	@Column	(name="pressao_diastolica") 
	private Integer pressao_diastolica;
	
	@Column	(name="data_hora") 
    private Date hora_medicao;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Exame getExame() {
		return exame;
	}
	public void setExame(Exame exame) {
		this.exame = exame;
	}
	public Integer getPressao_sistolica() {
		return pressao_sistolica;
	}
	public void setPressao_sistolica(Integer pressao_sistolica) {
		this.pressao_sistolica = pressao_sistolica;
	}
	public Integer getPressao_diastolica() {
		return pressao_diastolica;
	}
	public void setPressao_diastolica(Integer pressao_diastolica) {
		this.pressao_diastolica = pressao_diastolica;
	}
	public Date getHora_medicao() {
		return hora_medicao;
	}
	public void setHora_medicao(Date hora_medicao) {
		this.hora_medicao = hora_medicao;
	} 
    
    
}
