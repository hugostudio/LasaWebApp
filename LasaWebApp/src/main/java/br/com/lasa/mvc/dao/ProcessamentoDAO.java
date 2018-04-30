package br.com.lasa.mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.com.lasa.mvc.entity.Processamento;


@Transactional
@Repository
public class ProcessamentoDAO implements IProcessamentoDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;	

	@SuppressWarnings("unchecked")
	public List<Processamento> getAllProcessamentos() {
		String hql = "FROM tb_processamento as p ORDER BY p.id";
		return (List<Processamento>) entityManager.createQuery(hql).getResultList();
	}

	public Processamento getProcessamentoById(Long processamentoId) {
		return entityManager.find(Processamento.class, processamentoId);
	}

	public void addProcessamento(Processamento processamento) {
		entityManager.persist(processamento);
	}

}
