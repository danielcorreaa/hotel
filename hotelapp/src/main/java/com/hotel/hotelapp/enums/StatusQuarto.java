package com.hotel.hotelapp.enums;

public enum StatusQuarto {

	DISPONIVEL(1, "disponível"), OCUPADO(2, "Ocupado");

	private int codigo;
	private String descricao;

	private StatusQuarto(int codigo, String descricao) {
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