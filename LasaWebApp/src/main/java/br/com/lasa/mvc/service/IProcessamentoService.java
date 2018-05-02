package br.com.lasa.mvc.service;

import java.util.List;
import br.com.lasa.mvc.entity.Processamento;

public interface IProcessamentoService {
	List<Processamento> getProcessamentoByFiltro(Long processamentoId);
	public List<Processamento> getNextLote();
	public boolean exportarProcessamentoVenda();
}
