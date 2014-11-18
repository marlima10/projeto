package br.marcelo.tcc.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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
	private String observacoes;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "exame")
	@Cascade(CascadeType.ALL)
	private Collection<Medicoes> medicoes;
	
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
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public Collection<Medicoes> getMedicoes() {
		return medicoes;
	}
	public void setMedicoes(Collection<Medicoes> medicoes) {
		this.medicoes = medicoes;
	}	
	public Collection<Medicoes> getMedicoesUltimas() {
		List<Medicoes> ultimasMedicoes = new ArrayList<Medicoes>();
		Integer i = 0;
		for(Medicoes m:medicoes){
			ultimasMedicoes.add(m);
			if (i>=2){
				break;
			}else{
				i++;
			}
		}
		return ultimasMedicoes;
	}	
}
