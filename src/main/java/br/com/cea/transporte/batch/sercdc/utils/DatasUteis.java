package br.com.cea.transporte.batch.sercdc.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DatasUteis {

	private static final String DATA_ARQUIVO = "YYYYMMddHHmm";

	private static Locale LOCALE = new Locale("pt", "BR");

	public static String data() {
		GregorianCalendar calendar = new GregorianCalendar();
		SimpleDateFormat formatador = new SimpleDateFormat(DATA_ARQUIVO, LOCALE);
		return formatador.format(calendar.getTime());
	}

	public static String data(Date dataRota) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(dataRota);
		SimpleDateFormat formatador = new SimpleDateFormat(DATA_ARQUIVO, LOCALE);
		return formatador.format(calendar.getTime());

	}

}
