package br.com.lasa.mvc.dao;

import java.util.List;

import br.com.lasa.mvc.entity.Venda;
public interface IVendaDAO {
    List<Venda> getAllVendas();
    Venda getNextOldVenda();
    Venda getVendaById(Long vendaId);
    void addVenda(Venda venda);
    void updateVenda(Venda venda);
    void deleteVenda(Long vendaId);
}
