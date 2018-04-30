package br.com.lasa.mvc.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lasa.mvc.dao.IProcessamentoDAO;
import br.com.lasa.mvc.dao.IVendaDAO;
import br.com.lasa.mvc.entity.Processamento;
import br.com.lasa.mvc.entity.Venda;

@Service
public class VendaService implements IVendaService {

	@Autowired
	private IVendaDAO vendaDAO;
	
	@Autowired
	private IProcessamentoDAO processamentoDAO;
	
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


	private String gerarNomeArq(Venda venda) {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append(venda.getData());
		strBuff.append(" - ");
		strBuff.append(venda.getLoja());
		strBuff.append(" - ");
		strBuff.append(venda.getId());
		return strBuff.toString();
	}


	public boolean consolidarVenda() {
		try {
			Venda vnd = getNextOldVenda();
			Processamento proc = new Processamento();
			
			proc.setData(new Date());
			proc.setLoja(vnd.getLoja());
			proc.setPdv(vnd.getPdv());
			proc.setStatus("PENDENTE");
			proc.setNomeArquivo(gerarNomeArq(vnd));
			processamentoDAO.addProcessamento(proc);
			
			vnd.setStatus("OK");
			vendaDAO.updateVenda(vnd);
			return true;
			
		} catch(Exception E){
			return false;
		}	
	}

}
