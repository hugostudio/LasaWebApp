package br.com.lasa.mvc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ItemVendaPK implements Serializable {

	private static final long serialVersionUID = 2801612039276694146L;

	@Column(name="id_venda", nullable=false)
    private Long idVenda;
	
	@Column(name="id_item_venda", nullable=false)
    private Long idItemVenda;
	
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
