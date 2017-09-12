package com.hotel.hotelapp.test;

import org.junit.Assert;
import org.junit.Test;

import com.hotel.hotelapp.enums.TipoDocumento;
import com.hotel.hotelapp.enums.TipoHospede;
import com.hotel.hotelapp.model.Documento;
import com.hotel.hotelapp.model.Endereco;
import com.hotel.hotelapp.model.Hospede;
import com.hotel.hotelapp.model.Pessoa;

public class HospedeTest {
	
	@Test
	public void deveRetornarTipoDoHospedePessoaFisica() {
		Endereco endereco = new Endereco();
		endereco.setBairro("Centro");
		endereco.setCep("34234997");
		endereco.setCidade("Belo Horizonte");
		endereco.setEstado("MG");
		endereco.setNumero("4343");
		endereco.setRua("Pirai do sul");
		
		Documento documento = new Documento();
		documento.setDocumento("43498776634");
		Pessoa pessoa = new Pessoa("Joao dos Santos", documento, endereco, "3434-3434");
		Hospede hospede = new Hospede(pessoa);
	
		Assert.assertEquals(TipoHospede.PESSOA_FISICA, hospede.getTipoHospede());
		Assert.assertEquals(TipoDocumento.CPF, hospede.getDocumento());
		
	}

}