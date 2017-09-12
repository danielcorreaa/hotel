package com.hotel.hotelapp.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hotel.hotelapp.enums.StatusQuarto;
import com.hotel.hotelapp.exception.HospedagemInvalidaException;
import com.hotel.hotelapp.model.Documento;
import com.hotel.hotelapp.model.Endereco;
import com.hotel.hotelapp.model.Funcionario;
import com.hotel.hotelapp.model.Hospede;
import com.hotel.hotelapp.model.Pessoa;
import com.hotel.hotelapp.model.Quarto;
@SuppressWarnings("unused")
public class QuartoTest {
	
	private Quarto quarto1;
	private Quarto quarto2;
	
	private Quarto quarto3;
	private Quarto quarto4;
	private List<Hospede> acompanhantes;
	private Hospede cliente1;
	private Hospede cliente2;
	private Hospede cliente3;
	private Hospede cliente4;
	private Funcionario funcionario;
	
	@Before
	public void iniciar() {
		
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
		
		cliente1 = new Hospede(pessoa1);
		cliente2 = new Hospede(pessoa2);
		cliente3 = new Hospede(pessoa3);
		cliente4 = new Hospede(pessoa4);
		

		Pessoa pessoa5 = new Pessoa();
		pessoa5.setNome("Alvaro Ramos");
		pessoa5.setTelefone("3434343");
		
		funcionario = new Funcionario(pessoa5, "alvaro45", "12345");
		
		quarto1 = new Quarto(23, StatusQuarto.DISPONIVEL, 3);
		quarto2 = new Quarto(24, StatusQuarto.OCUPADO, 2);
		quarto3 = new Quarto(25, StatusQuarto.DISPONIVEL, 3);
		quarto4 = new Quarto(26, StatusQuarto.OCUPADO, 3);
		
	}
	
	@Test
	public void deveValidarDisponibilidadeQuarto() throws HospedagemInvalidaException {
		quarto1.validaDisponibildadeQuarto();
		Assert.assertEquals(StatusQuarto.DISPONIVEL, quarto1.getStatusQuarto());
	}
	
	@Test(expected=HospedagemInvalidaException.class)
	public void deveRetornarExceptionPorQueQuartoNaoEstaDisponivel() throws HospedagemInvalidaException {
		quarto2.validaDisponibildadeQuarto();		
	}
	
	@Test
	public void deveValidarQuantidadeDePessoasFisicasParaOQuarto() throws HospedagemInvalidaException {
		acompanhantes = Arrays.asList(cliente3, cliente1, cliente4);
		quarto1.validaCapacidadeQuarto(acompanhantes, cliente2);
	}
	@Test(expected=HospedagemInvalidaException.class)
	public void deveRetornarExceptionPorEstourarCapacidadeDePessoasNoQuarto() throws HospedagemInvalidaException {
		acompanhantes = Arrays.asList(cliente3, cliente1, cliente4);
		quarto1.validaCapacidadeQuarto(acompanhantes, cliente1);
	}

}
