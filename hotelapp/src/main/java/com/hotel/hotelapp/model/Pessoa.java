package com.hotel.hotelapp.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Pessoa {

	
	@Column(length = 40)
	private String nome;
	@Embedded
	private Documento documento;
	@Embedded
	private Endereco endereco;
	@Column(length = 20)
	private String telefone;

	public Pessoa(String nome, Documento documento, Endereco endereco, String telefone) {
		super();
		this.nome = nome;
		this.documento = documento;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Pessoa() {
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
}