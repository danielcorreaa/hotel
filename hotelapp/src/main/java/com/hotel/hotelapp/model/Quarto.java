package com.hotel.hotelapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.hotel.hotelapp.enums.StatusQuarto;
import com.hotel.hotelapp.enums.TipoDocumento;
import com.hotel.hotelapp.exception.HospedagemInvalidaException;

@Entity
public class Quarto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer numeroPorta;
	@Enumerated(EnumType.STRING)
	private StatusQuarto statusQuarto;
	private int capacidade;

	public Boolean validaDisponibildadeQuarto() throws HospedagemInvalidaException {
		if (this.getStatusQuarto().equals(StatusQuarto.OCUPADO)) {
			throw new HospedagemInvalidaException("Quarto está ocupado");
		}
		return Boolean.TRUE;
	}

	public Boolean validaCapacidadeQuarto(List<Hospede> acompanhantes, Hospede hospede)
			throws HospedagemInvalidaException {
		int valorHospede = validaHospedeFisicoOuJuridico(hospede);
		if ((acompanhantes.size() + valorHospede) > this.getCapacidade()) {
			throw new HospedagemInvalidaException("Numero de hóspede maior que a capacidade do quarto");
		}
		return Boolean.TRUE;
	}

	private int validaHospedeFisicoOuJuridico(Hospede hospede) {		
		if (hospede.getDocumento().equals(TipoDocumento.CPF)) {
			return 1;
		}
		return 0;
	}

	public StatusQuarto desocuparQuarto() {
		return StatusQuarto.DISPONIVEL;
	}

	public Quarto() {
	}

	public Quarto(int numeroPorta, StatusQuarto statusQuarto, int capacidade) {
		super();
		this.numeroPorta = numeroPorta;
		this.statusQuarto = statusQuarto;
		this.capacidade = capacidade;
	}

	public int getNumeroPorta() {
		return numeroPorta;
	}

	public void setNumeroPorta(int numeroPorta) {
		this.numeroPorta = numeroPorta;
	}

	public StatusQuarto getStatusQuarto() {
		return statusQuarto;
	}

	public void setStatusQuarto(StatusQuarto statusQuarto) {
		this.statusQuarto = statusQuarto;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroPorta == null) ? 0 : numeroPorta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quarto other = (Quarto) obj;
		if (numeroPorta == null) {
			if (other.numeroPorta != null)
				return false;
		} else if (!numeroPorta.equals(other.numeroPorta))
			return false;
		return true;
	}

}