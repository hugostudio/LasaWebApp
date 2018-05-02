package br.com.lasa.mvc.service;


import java.io.BufferedWriter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.lasa.mvc.dao.IProcessamentoDAO;

import br.com.lasa.mvc.entity.Processamento;


@Service
public class ProcessamentoService implements IProcessamentoService {

	@Autowired
	private IProcessamentoDAO processamentoDAO;

	@Autowired
	private IFlatFileService flatFileService;
	
	public List<Processamento> getProcessamentoByFiltro(Long processamentoId) {
		return processamentoDAO.getProcessamentoByFiltro(processamentoId);
	}


	public List<Processamento> getNextLote() {
		return processamentoDAO.getNextLote();
	}
	
	public boolean exportarProcessamentoVenda(){
		try {
			List<Processamento> processamentos = processamentoDAO.getNextLote();
			if((processamentos != null)&&(!processamentos.isEmpty())) {
				flatFileService.gerarNovoNomeArquivo();
	            BufferedWriter bw = flatFileService.getflatFile();

				for(Processamento item : processamentos) {
					bw.write(item.toStringFormat());
		            bw.newLine();		
		            item.setNomeArquivo(flatFileService.getFlatFileName());
		            item.setStatus("PROCESSADO");
		            processamentoDAO.updateProcessamento(item);
				}
				bw.close();
				return true;
				
			}else{
				return false;
			}
		} catch(Exception E){
			return false;
		}	
	}

}
