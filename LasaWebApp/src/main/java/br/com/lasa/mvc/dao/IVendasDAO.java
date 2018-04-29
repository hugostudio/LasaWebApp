package br.com.lasa.mvc.dao;

import java.util.List;

import br.com.lasa.mvc.entity.Venda;
public interface IVendasDAO {
    List<Venda> getAllVendas();
    Venda getVendaById(int VendaId);
    void addVenda(Venda Venda);
    void updateVenda(Venda Venda);
    void deleteVenda(int VendaId);
    boolean VendaExists(String title, String category);
}
