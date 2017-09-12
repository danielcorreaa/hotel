package com.hotel.hotelapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.hotel.hotelapp.enums.StatusHospedagem;
import com.hotel.hotelapp.exception.HospedagemInvalidaException;

@Entity
public class Hospedagem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "hospede_ID")
	private Hospede hospede;
	@ManyToMany
	@JoinTable(name = "hospede_hospedagem", joinColumns = {
			@JoinColumn(name = "hospedagem_id") }, inverseJoinColumns = { @JoinColumn(name = "hospede_id") })
	private List<Hospede> acompanhantes;
	@ManyToOne
	@JoinColumn(name = "funcionario_ID")
	private Funcionario funcionario;
	private Date dataEntrada;
	private Date dataSaida;
	private StatusHospedagem statusHospedagem = StatusHospedagem.INATIVA;
	@ManyToOne
	@JoinColumn(name = "quarto_ID")
	private Quarto quarto;

	public void checkIn(Hospede hospede, List<Hospede> acompanhantes, Quarto quarto, Date dataEntrada, Date dataSaida,
			List<Hospedagem> hospedagens, Funcionario funcionario) throws HospedagemInvalidaException {
		Boolean valido = Boolean.FALSE;
		valido = quarto.validaDisponibildadeQuarto();
		valido = quarto.validaCapacidadeQuarto(acompanhantes, hospede);
		valido = validarDisponibilidadeDasDatas(hospedagens, dataEntrada, dataSaida);
		if (valido) {
			this.hospede = hospede;
			this.acompanhantes = acompanhantes;
			this.quarto = quarto;
			this.dataEntrada = dataEntrada;
			this.dataSaida = dataSaida;
			this.statusHospedagem = StatusHospedagem.ATIVA;
			this.funcionario = funcionario;
		}

	}

	public void checkOut(Hospedagem hospedagem) {
		hospedagem.statusHospedagem = StatusHospedagem.INATIVA;
		hospedagem.getQuarto().desocuparQuarto();
	}

	private Boolean validarDisponibilidadeDasDatas(List<Hospedagem> hospedagens, Date dataEntrada, Date dataSaida)
			throws HospedagemInvalidaException {
		List<Calendar> todasAsDatas = obterDatasEntreEntradaESaida(dataEntrada, dataSaida);
		if (hospedagens != null && !hospedagens.isEmpty()) {
			for (Hospedagem hospedagem : hospedagens) {
				for (Calendar calendar : todasAsDatas) {
					if (hospedagem.getDataEntrada().equals(calendar.getTime())
							|| hospedagem.getDataSaida().equals(calendar.getTime())) {
						throw new HospedagemInvalidaException("Sem diponíbilidade para a data informada");
					}
				}
			}
		}
		return Boolean.TRUE;
	}

	private List<Calendar> obterDatasEntreEntradaESaida(Date dataEntrada, Date dataSaida) {
		Calendar entrada = Calendar.getInstance();
		Calendar saida = Calendar.getInstance();
		entrada.setTime(dataEntrada);
		saida.setTime(dataSaida);
		List<Calendar> datas = new ArrayList<Calendar>();
		int contador = 0;
		while (entrada.getTime().before(saida.getTime())) {
			entrada.add(Calendar.DATE, contador);
			contador++;
			Calendar data = Calendar.getInstance();
			data.setTime(entrada.getTime());
			datas.add(data);
		}
		return datas;
	}

	public Hospedagem() {

	}

	public Hospede getHospede() {
		return hospede;
	}

	public List<Hospede> getAcompanhantes() {
		return acompanhantes;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public StatusHospedagem getStatusHospedagem() {
		return statusHospedagem;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Hospedagem other = (Hospedagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}