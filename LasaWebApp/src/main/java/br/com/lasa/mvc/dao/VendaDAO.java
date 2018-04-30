package br.com.lasa.mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.lasa.mvc.entity.Venda;


@Transactional
@Repository
public class VendaDAO implements IVendaDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;	

	public Venda getVendaById(Long VendaId) {
		return entityManager.find(Venda.class, VendaId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Venda> getAllVendas() {
		String hql = "FROM tb_venda as v ORDER BY v.id";
		return (List<Venda>) entityManager.createQuery(hql).getResultList();
	}	
	
	public void addVenda(Venda Venda) {
		entityManager.persist(Venda);
	}
	
	public void updateVenda(Venda Venda) {
		Venda vnd = getVendaById(Venda.getId());
		vnd.setData(Venda.getData());
		vnd.setLoja(Venda.getLoja());
		vnd.setPdv(Venda.getPdv());
		vnd.setStatus(Venda.getStatus());
		entityManager.flush();
	}


	public void deleteVenda(Long VendaId) {
		entityManager.remove(getVendaById(VendaId));
	}
	
} 