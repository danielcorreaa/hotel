package com.hotel.hotelapp.enums;

public enum StatusHospedagem {

	ATIVA(1, "Ativa"), INATIVA(2, "Inativa");

	private int codigo;
	private String descricao;

	private StatusHospedagem(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

}