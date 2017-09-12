package com.hotel.hotelapp.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hotel.hotelapp.enums.StatusHospedagem;
import com.hotel.hotelapp.enums.StatusQuarto;
import com.hotel.hotelapp.exception.HospedagemInvalidaException;
import com.hotel.hotelapp.model.Funcionario;
import com.hotel.hotelapp.model.Hospedagem;
import com.hotel.hotelapp.model.Hospede;
import com.hotel.hotelapp.model.Pessoa;
import com.hotel.hotelapp.model.Quarto;

import junit.framework.Assert;

public class HospedagemTest {
	
	Hospede cliente1;
	Hospede cliente2;
	Hospede cliente3;
	Hospede cliente4;
	
	Quarto quarto1;
	Quarto quarto2;
	Quarto quarto3;
	
	Funcionario funcionario;
	
	@Before
	public void inicia() {
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("Pedro Henrique");
		pessoa1.setTelefone("3434343");
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("Marco Felipe");
		pessoa2.setTelefone("34554");
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setNome("Adivan Ferreira");
		pessoa3.setTelefone("3434343");
		
		Pessoa pessoa4 = new Pessoa();
		pessoa4.setNome("Alice Pereira");
		pessoa4.setTelefone("3434343");
		
		cliente1 = new Hospede(pessoa1);
		cliente2 = new Hospede(pessoa2);
		cliente3 = new Hospede(pessoa3);
		cliente4 = new Hospede(pessoa4);
		
		quarto1 = new Quarto(20, StatusQuarto.DISPONIVEL, 3);
		quarto2 = new Quarto(21, StatusQuarto.DISPONIVEL, 5);
		quarto3 = new Quarto(22, StatusQuarto.OCUPADO, 2);
		
		Pessoa pessoa5 = new Pessoa();
		pessoa5.setNome("Alvaro Ramos");
		pessoa5.setTelefone("3434343");
		
		funcionario = new Funcionario(pessoa5, "alvaro45", "12345");
	}
	
	@Test
	public void devehospedarCliente() throws HospedagemInvalidaException {
		Hospedagem hospedagem = new Hospedagem();
		Date dataEntrada = DataUtil.obterData("05/06/2017");
		Date dadaSaida = DataUtil.obterData("07/06/2017");;
		List<Hospedagem> hospedagens = new ArrayList<Hospedagem>();
		List<Hospede> acompanhantes = Arrays.asList(cliente2, cliente3);
		hospedagem.checkIn(cliente1, acompanhantes, quarto1, dataEntrada, dadaSaida, hospedagens,funcionario);
		
		Assert.assertEquals(StatusHospedagem.ATIVA.getDescricao(), hospedagem.getStatusHospedagem().getDescricao());
	}
	@Test(expected=HospedagemInvalidaException.class)
	public void naoDeveHospedarComDatasInvalidas() throws HospedagemInvalidaException {
		Hospedagem hospedagem = new Hospedagem();
		Date dataEntrada = DataUtil.obterData("05/06/2017");
		Date dadaSaida = DataUtil.obterData("07/06/2017");;
		List<Hospedagem> hospedagens = new ArrayList<Hospedagem>();
		List<Hospede> acompanhantes = Arrays.asList(cliente2, cliente3);
		hospedagem.checkIn(cliente1, acompanhantes, quarto1, dataEntrada, dadaSaida, hospedagens,funcionario);
		
		hospedagens.add(hospedagem);
		
		Hospedagem hospedagem2 = new Hospedagem();
		dataEntrada = DataUtil.obterData("04/06/2017");
		dadaSaida = DataUtil.obterData("08/06/2017");
		hospedagem2.checkIn(cliente4, acompanhantes, quarto2, dataEntrada, dadaSaida, hospedagens,funcionario);	
	}
	
	@Test(expected=HospedagemInvalidaException.class)
	public void naoDeveHospedarQuartoOcupado() throws HospedagemInvalidaException {
		Hospedagem hospedagem = new Hospedagem();
		Date dataEntrada = DataUtil.obterData("05/06/2017");
		Date dadaSaida = DataUtil.obterData("07/06/2017");;
		List<Hospedagem> hospedagens = new ArrayList<Hospedagem>();
		List<Hospede> acompanhantes = Arrays.asList(cliente2, cliente3);
		hospedagem.checkIn(cliente1, acompanhantes, quarto3, dataEntrada, dadaSaida, hospedagens,funcionario);
		
	}
	
	@Test(expected=HospedagemInvalidaException.class)
	public void naoDeveHospedarMaisHospedesDoQueSuportadoPeloQuarto() throws HospedagemInvalidaException {
		Hospedagem hospedagem = new Hospedagem();
		Date dataEntrada = DataUtil.obterData("05/06/2017");
		Date dadaSaida = DataUtil.obterData("07/06/2017");;
		List<Hospedagem> hospedagens = new ArrayList<Hospedagem>();
		List<Hospede> acompanhantes = Arrays.asList(cliente2, cliente3,cliente4);
		hospedagem.checkIn(cliente1, acompanhantes, quarto1, dataEntrada, dadaSaida, hospedagens,funcionario);
		
	}
	
	@Test
	public void deveEncerrarUmaHospedagem() throws HospedagemInvalidaException {		
		Hospedagem hospedagem = new Hospedagem();
		Date dataEntrada = DataUtil.obterData("05/06/2017");
		Date dadaSaida = DataUtil.obterData("07/06/2017");;
		List<Hospedagem> hospedagens = new ArrayList<Hospedagem>();
		List<Hospede> acompanhantes = Arrays.asList(cliente2, cliente3);
		hospedagem.checkIn(cliente1, acompanhantes, quarto1, dataEntrada, dadaSaida, hospedagens,funcionario);
		
		hospedagem.checkOut(hospedagem);
		
		Assert.assertEquals(StatusQuarto.DISPONIVEL, hospedagem.getQuarto().getStatusQuarto());		
		Assert.assertEquals(StatusHospedagem.INATIVA, hospedagem.getStatusHospedagem());
		
	}

}
