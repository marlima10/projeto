package br.com.projeto.beans;

import java.util.Date;

public class Medicoes {
	private Integer id;
	private Integer id_exame;
	private Integer pressao_sistolica;
	private Integer pressao_diastolica;
    private Date hora_medicao;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_exame() {
		return id_exame;
	}
	public void setId_exame(Integer id_exame) {
		this.id_exame = id_exame;
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
