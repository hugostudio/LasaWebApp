package br.com.lasa.mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.com.lasa.mvc.entity.Processamento;


@Transactional
@Repository
public class ProcessamentoDAO implements IProcessamentoDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;	

	@SuppressWarnings("unchecked")
	public List<Processamento> getProcessamentoByFiltro(Long processamentoId) {
		String hql = "FROM tb_processamento as p ORDER BY p.id";
		return (List<Processamento>) entityManager.createQuery(hql).getResultList();
	}

	public void addProcessamento(Processamento processamento) {
		entityManager.persist(processamento);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Processamento> getNextLote() {
		try {
			String hql = "FROM tb_processamento as p ORDER BY p.id";
			Query q = entityManager.createQuery(hql);
			q.setMaxResults(10);
			return (List<Processamento>) q.getResultList();	
		}catch(NoResultException E){
			return null;
		}

	}

}
