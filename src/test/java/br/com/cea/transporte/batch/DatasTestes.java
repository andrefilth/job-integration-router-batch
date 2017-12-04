package br.com.cea.transporte.batch;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DatasTestes {

	public static void main(String[] args) {
		Locale locale = new Locale("pt", "BR");
		GregorianCalendar calendar = new GregorianCalendar();
		SimpleDateFormat formatador = new SimpleDateFormat("YYYYMMddHHmm", locale);
		String format = formatador.format(calendar.getTime());
		System.out.println(format);
	}
}
