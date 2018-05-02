package br.com.lasa.mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	
	public Venda getNextOldVenda() {
		try {
			String hql = "FROM tb_venda as v JOIN FETCH v.itens WHERE v.status = 'NÃO PROCESSADO' order by v.data asc";
			Query q = entityManager.createQuery(hql);
			q.setMaxResults(1);
			return (Venda) q.getSingleResult();	
		}catch(NoResultException E){
			return null;
		}
	}
	
	public void addVenda(Venda venda) {
		entityManager.persist(venda);
	}
	
	public void updateVenda(Venda venda) {
		Venda vnd = getVendaById(venda.getId());
		vnd.setData(venda.getData());
		vnd.setLoja(venda.getLoja());
		vnd.setPdv(venda.getPdv());
		vnd.setStatus(venda.getStatus());
		entityManager.flush();
	}


	public void deleteVenda(Long vendaId) {
		entityManager.remove(getVendaById(vendaId));
	}
	
} 