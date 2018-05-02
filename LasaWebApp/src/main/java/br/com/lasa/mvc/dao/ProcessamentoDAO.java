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
			String hql = "FROM tb_processamento as p WHERE p.status = 'PENDENTE' ORDER BY p.id";
			Query q = entityManager.createQuery(hql);
			q.setMaxResults(10);
			return (List<Processamento>) q.getResultList();	
		}catch(NoResultException E){
			return null;
		}

	}

	@Override
	public void updateProcessamento(Processamento processamento) {
		Processamento process = getProcessamentoById(processamento.getId());
		process.setData(processamento.getData());
		process.setDesconto(processamento.getDesconto());
		process.setLoja(processamento.getLoja());
		process.setPdv(processamento.getPdv());
		process.setNomeArquivo(processamento.getNomeArquivo());
		process.setPrecoUnitario(processamento.getPrecoUnitario());
		process.setProduto(processamento.getProduto());
		process.setStatus(processamento.getStatus());
		entityManager.flush();	
	}

	@Override
	public Processamento getProcessamentoById(Long processamentoId) {
		return entityManager.find(Processamento.class, processamentoId);
	}

}
