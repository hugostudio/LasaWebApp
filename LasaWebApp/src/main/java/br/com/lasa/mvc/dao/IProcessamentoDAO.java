package br.com.lasa.mvc.dao;

import java.util.List;
import br.com.lasa.mvc.entity.Processamento;

public interface IProcessamentoDAO {
    List<Processamento> getNextLote();
    List<Processamento> getProcessamentoByFiltro(Long processamentoId);
    Processamento getProcessamentoById(Long processamentoId);
    void addProcessamento(Processamento processamento);
    void updateProcessamento(Processamento processamento);
}
