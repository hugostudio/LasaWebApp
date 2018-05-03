package br.com.lasa.mvc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemVendaPK implements Serializable {

	private static final long serialVersionUID = 2801612039276694146L;
	

	@Column(name="id_venda")
    private Long idVenda;
	 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_item_venda")
    private Long idItemVenda;
	
	@ManyToOne
	@JoinColumn(name = "id_venda", updatable = true, insertable = true)
	public Long getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(Long idVenda) {
		this.idVenda = idVenda;
	}
	public Long getIdItemVenda() {
		return idItemVenda;
	}
	public void setIdItemVenda(Long idItemVenda) {
		this.idItemVenda = idItemVenda;
	} 

}
