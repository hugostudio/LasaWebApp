package br.com.lasa.mvc.dao;

import java.util.List;

import br.com.lasa.mvc.entity.Processamento;

public interface IProcessamentoDAO {
    List<Processamento> getAllProcessamentos();
    Processamento getProcessamentoById(Long processamentoId);
    void addProcessamento(Processamento processamento);
}
