package br.com.cea.transporte.batch.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import br.com.cea.transporte.batch.sercdc.service.RotasService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class IntegrationItemReader implements ItemReader<Object> {

	private boolean batchJobState = false;

	@Autowired
	private RotasService service;

	@Value("${cea.batch.router.patch.file}")
	private String caminhoArquivoRotas;

	@Override
	public Object read() throws Exception {
		log.info("Processando...");
		if (!batchJobState) {
			this.service.gerarArquivo();
			batchJobState = true;
		}
		return null;
	}

}
