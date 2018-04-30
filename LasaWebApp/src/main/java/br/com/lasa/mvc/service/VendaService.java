package br.com.lasa.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lasa.mvc.dao.IVendaDAO;
import br.com.lasa.mvc.entity.Venda;

@Service
public class VendaService implements IVendaService {

	@Autowired
	private IVendaDAO vendaDAO;
	
	public List<Venda> getAllVendas() {
		return vendaDAO.getAllVendas();
	}


	public Venda getVendaById(Long vendaId) {
		return vendaDAO.getVendaById(vendaId);
	}


	public boolean addVenda(Venda venda) {
		try {
			vendaDAO.addVenda(venda);
			return true;
		}
		catch(Exception E) {
			return false;
		}
	}


	public void updateVenda(Venda venda) {
		vendaDAO.updateVenda(venda);
	}


	public void deleteVenda(Long vendaId) {
		vendaDAO.deleteVenda(vendaId);
	}


	public Venda getNextOldVenda() {
		return vendaDAO.getNextOldVenda();
	}

}
