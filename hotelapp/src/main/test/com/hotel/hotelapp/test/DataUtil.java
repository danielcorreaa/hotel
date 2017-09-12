package com.hotel.hotelapp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DataUtil {
	
	public static void main(String[] args) {
		Date dataEntrada = DataUtil.obterData("05/06/2017");
		Date dadaSaida = DataUtil.obterData("08/06/2017");
		Calendar entrada = Calendar.getInstance();
		Calendar saida = Calendar.getInstance();
		entrada.setTime(dataEntrada);
		saida.setTime(dadaSaida);
		List<Calendar> datas = new ArrayList<Calendar>();
		int contador = 0;
		while (entrada.getTime().before(saida.getTime())) {
			entrada.add(Calendar.DATE, contador);
			contador++;
			Calendar data = Calendar.getInstance();
			data.setTime(entrada.getTime());
			datas.add(data);
		}

	}

	public static Date obterData(String dataEntrada) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return sdf.parse(dataEntrada);
		} catch (ParseException e) {
			return new Date();
		}
	}
}
