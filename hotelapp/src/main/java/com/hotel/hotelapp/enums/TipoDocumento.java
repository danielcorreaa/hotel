package com.hotel.hotelapp.enums;

public enum TipoDocumento {

	CPF(1, "Cpf"), CNPJ(2, "Cnpj");

	private int codigo;
	private String descrica;

	private TipoDocumento(int codigo, String descrica) {
		this.codigo = codigo;
		this.descrica = descrica;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescrica() {
		return descrica;
	}

}