package com.hotel.hotelapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.hotel.hotelapp.model.Documento;
import com.hotel.hotelapp.model.Endereco;
import com.hotel.hotelapp.model.Hospede;
import com.hotel.hotelapp.model.Pessoa;

public class HospedeDAO {
	
	public List<Hospede> hospedes(){
		List<Hospede> response = new ArrayList<Hospede>();
		Endereco endereco = new Endereco();
		endereco.setBairro("Centro");
		endereco.setCep("34234997");
		endereco.setCidade("Belo Horizonte");
		endereco.setEstado("MG");
		endereco.setNumero("4343");
		endereco.setRua("Pirai do sul");
		
		Documento cpf = new Documento();
		cpf.setDocumento("43498776634");
		
		Documento cnpj = new Documento();
		cnpj.setDocumento("43498776634456");
		
		Pessoa pessoa1 = new Pessoa("Joao dos Santos", cpf, endereco, "3434-3434");		
		Pessoa pessoa2 = new Pessoa("Marco Felipe",cnpj,endereco,"34554");		
		Pessoa pessoa3 = new Pessoa("Adivan Ferreira",cpf, endereco,"3434343" );		
		Pessoa pessoa4 = new Pessoa("Alice Pereira",cnpj, endereco,"3434343");
		
		
		
		return response;
		
	}

}