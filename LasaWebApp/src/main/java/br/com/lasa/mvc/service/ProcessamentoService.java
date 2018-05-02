package br.com.lasa.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lasa.mvc.dao.IProcessamentoDAO;
import br.com.lasa.mvc.entity.Processamento;

@Service
public class ProcessamentoService implements IProcessamentoService {

	@Autowired
	private IProcessamentoDAO processamentoDAO;

	
	public List<Processamento> getProcessamentoByFiltro(Long processamentoId) {
		return processamentoDAO.getProcessamentoByFiltro(processamentoId);
	}


	public List<Processamento> getNextLote() {
		return processamentoDAO.getNextLote();
	}
	


}
