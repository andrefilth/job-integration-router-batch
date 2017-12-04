package br.com.cea.transporte.batch.sercdc.data;

import br.com.cea.transporte.batch.sercdc.utils.DatasUteis;
import lombok.Data;

@Data
public class Arquivo {

	private String dataCriacao;

	private String nome;

	private String caminho;

	public Arquivo(String nomeBatch, String caminho) {
		this.dataCriacao = DatasUteis.data();
		this.nome = nomeBatch;
		this.caminho = caminho;
	}

	public String getNomeArquivo() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.caminho);
		sb.append(this.dataCriacao);
		sb.append("_");
		sb.append(this.nome);
		sb.append(".txt");
		return sb.toString();
	}

}
