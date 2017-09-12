package com.hotel.hotelapp.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.hotelapp.model.Documento;
import com.hotel.hotelapp.model.Endereco;
import com.hotel.hotelapp.model.Hospede;
import com.hotel.hotelapp.model.Pessoa;
import com.hotel.hotelapp.repository.HospedeRepository;


public class HospedeRepositoryTest {
	
	@Autowired
	private HospedeRepository dao;
	
	@Test
	public void deveGravarHospedeNoBanco(){
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
		
	}

}
