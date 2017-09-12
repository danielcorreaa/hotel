package com.hotel.hotelapp.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.hotel.hotelapp.enums.TipoDocumento;

@Embeddable
public class Documento {

	@Column(length = 40)
	private String documento;
	@Enumerated(EnumType.STRING)
	private TipoDocumento tipoDocumento;

	public Documento() {
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public TipoDocumento getTipoDocumento() {
		if (this.documento.length() == 11) {
			tipoDocumento = TipoDocumento.CPF;
		} else {
			tipoDocumento = TipoDocumento.CNPJ;
		}
		return tipoDocumento;
	}

}