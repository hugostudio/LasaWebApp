package br.com.lasa.mvc.service;

import java.util.List;

import br.com.lasa.mvc.entity.Venda;

public interface IVendaService {
	List<Venda> getAllVendas();
	Venda getNextOldVenda();
    Venda getVendaById(Long vendaId);
    boolean addVenda(Venda venda);
    void updateVenda(Venda venda);
    void deleteVenda(Long vendaId);
}
