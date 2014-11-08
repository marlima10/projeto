package com.dtr.oas.model;

import javax.persistence.*;;

@Entity
@Table(name="strategy",schema="projeto")
public class Strategy {
	
	@Id
	@SequenceGenerator	(name =	"SEQ_TESTE",sequenceName ="projeto.seq_strategy") 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TESTE")
	private Integer id;
	@Column	(name="type") 
	private String type;
	@Column	(name="name") 
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
