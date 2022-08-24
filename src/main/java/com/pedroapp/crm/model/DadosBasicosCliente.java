package com.pedroapp.crm.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DadosBasicosCliente {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	private String curso;
	private String nome;
	
	public DadosBasicosCliente(Cliente cliente) {
		this.curso=cliente.getCurso();
		this.nome = cliente.getNome();
		this.id = cliente.getId();
		
	}
	
	
	
	public DadosBasicosCliente(Long id, String curso, String nome) {
	
		this.curso = curso;
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}
	public String getCurso() {
		return curso;
	}
	public String getNome() {
		return nome;
	}
	
	

	



	

}
