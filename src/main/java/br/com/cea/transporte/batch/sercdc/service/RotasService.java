package br.com.cea.transporte.batch.sercdc.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.cea.transporte.batch.sercdc.data.Arquivo;
import br.com.cea.transporte.batch.sercdc.data.RegistroArquivo;
import br.com.cea.transporte.batch.sercdc.model.RotasDestino;
import br.com.cea.transporte.batch.sercdc.model.RotasMaster;
import lombok.extern.java.Log;

@Log
@Service
public class RotasService {

	private static final String CQ = "CQ";

	private static final String ROUTE_DATE = "route_date";

	private static final String ROUTE_DEST = "route_dest";

	private static final String CARRIER_SERVICE = "carrier_service_route";

	@Value("${cea.batch.router.patch.file}")
	private String caminhoArquivoRotas;

	@Autowired
	private RotasMasterService masterService;

	@Autowired
	private RotasDestinoService comprasService;

	public void gerarArquivo() {
		this.arquivoRotas();
		this.arquivoDestino();
		this.arquivoTransporte();
	}

	private void arquivoTransporte() {

		List<RotasMaster> list = this.masterService.consultarRotas();
		Arquivo arq = new Arquivo(CARRIER_SERVICE, caminhoArquivoRotas);
		String nomeArquivo = arq.getNomeArquivo();
		File arquivo = new File(nomeArquivo);
		try {
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true));
			for (RotasMaster rotas : list) {
				RegistroArquivo registroArquivo = new RegistroArquivo(CQ, "CYA", "D", rotas.getId(), "RESGUARDO");
				bw.write(registroArquivo.getResgistrosTransporte());
				bw.newLine();
			}
			bw.close();
			log.info("Arquivo " + nomeArquivo + "  criado com sucesso");
		} catch (IOException ex) {
			log.info("Erro ao montar arquivo" + nomeArquivo);
			throw new RuntimeException("Erro ao montar arquivo" + nomeArquivo);
		}

	}

	private void arquivoDestino() {
		List<RotasDestino> list = this.comprasService.consultar();
		Arquivo arq = new Arquivo(ROUTE_DEST, caminhoArquivoRotas);
		String nomeArquivo = arq.getNomeArquivo();
		File arquivo = new File(nomeArquivo);
		try {
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true));
			int index = 1;
			for (RotasDestino rotas : list) {
				RegistroArquivo registroArquivo = new RegistroArquivo(CQ, rotas.getId(), rotas.getArmazem().getId(),
						index);
				bw.write(registroArquivo.getResgistrosArmazem());
				bw.newLine();
				index++;
			}
			bw.close();
			log.info("Arquivo " + nomeArquivo + "  criado com sucesso");
		} catch (IOException ex) {
			log.info("Erro ao montar arquivo" + nomeArquivo);
		}
	}

	private void arquivoRotas() {
		List<RotasMaster> list = this.masterService.consultarRotas();
		Arquivo arq = new Arquivo(ROUTE_DATE, caminhoArquivoRotas);
		String nomeArquivo = arq.getNomeArquivo();
		File arquivo = new File(nomeArquivo);
		try {
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true));
			int index = 1;
			for (RotasMaster rotas : list) {
				RegistroArquivo registroArquivo = new RegistroArquivo(CQ, rotas.getId(), index);
				bw.write(registroArquivo.getResgistrosRotas());
				bw.newLine();
				index++;
			}
			bw.close();
			log.info("Arquivo " + nomeArquivo + "  criado com sucesso");
		} catch (IOException ex) {
			log.info("Erro ao montar arquivo" + nomeArquivo);
		}
	}

}
