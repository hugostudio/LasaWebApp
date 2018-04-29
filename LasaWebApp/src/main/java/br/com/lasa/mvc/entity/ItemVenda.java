package br.com.lasa.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 

@Entity(name="tb_item_venda")
public class ItemVenda { 
    
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private ItemVendaPK id; 
    
    @Column(name="produto", nullable=false)
    private String produto; 	
    
    @Column(name="preco_unitario", nullable=false)
    private float precoUnitario;
    
    @Column(name="desconto", nullable=false)
    private float desconto;


	public ItemVendaPK getId() {
		return id;
	}

	public void setId(ItemVendaPK id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public float getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(float precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

}
