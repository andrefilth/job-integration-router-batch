package br.com.cea.transporte.batch.sercdc.data;

import org.apache.commons.lang3.StringUtils;

import br.com.cea.transporte.batch.sercdc.utils.DatasUteis;

public class RegistroArquivo {

	private String facilityId;
	private String transactionTs;
	private Long route;
	private String dataAtual;
	private int sequence;
	private Long armazemId;
	private String carrierCode;
	private String serviceCode;
	private String locationId;

	public RegistroArquivo(String facilityId,Long route, int sequence) {
		this.facilityId = facilityId;
		this.transactionTs = DatasUteis.data();
		this.route = route;
		this.dataAtual = this.transactionTs;
		this.sequence = sequence;
	}
	
	public RegistroArquivo(String facilityId, Long route, Long armazemId, int sequence) {
		this.facilityId = facilityId;
		this.transactionTs = DatasUteis.data();
		this.route = route;
		this.armazemId = armazemId;
		this.dataAtual = this.transactionTs;
		this.sequence = sequence;
		
	}
	
	public RegistroArquivo(String facilityId, String carrierCode, String serviceCode, Long route, String locationId) {
		this.facilityId = facilityId;
		this.transactionTs = DatasUteis.data();
		this.carrierCode = carrierCode;
		this.serviceCode = serviceCode;
		this.route = route;
		this.dataAtual = transactionTs;
		this.locationId = locationId;
	}

	public String getResgistrosTransporte() {
		StringBuffer sb = new StringBuffer();
		sb.append(facilityId);
		sb.append(transactionTs);
		sb.append(StringUtils.leftPad(carrierCode, 4, "0"));
		sb.append(StringUtils.leftPad(serviceCode, 6, "0"));
		sb.append(String.format("%010d", route));
		sb.append(dataAtual);
		sb.append(StringUtils.leftPad(locationId, 16, "0"));
		return sb.toString();
	}
	public String getResgistrosRotas() {
		StringBuffer sb = new StringBuffer();
		sb.append(facilityId);
		sb.append(transactionTs);
		sb.append(String.format("%010d", route));
		sb.append(dataAtual);
		sb.append(String.format("%03d", sequence));
		return sb.toString();
	}

	public String getResgistrosArmazem() {
		StringBuffer sb = new StringBuffer();
		sb.append(facilityId);
		sb.append(transactionTs);
		sb.append(String.format("%010d", route));
		sb.append(String.format("%010d", armazemId));
		sb.append(dataAtual);
		sb.append(String.format("%03d", sequence));
		return sb.toString();
	}

}
