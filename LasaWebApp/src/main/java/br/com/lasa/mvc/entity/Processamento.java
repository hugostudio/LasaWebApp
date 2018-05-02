package br.com.lasa.mvc.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 

@Entity(name="tb_processamento")
public class Processamento {
    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Processamento [id=");
		builder.append(id);
		builder.append(", idVenda=");
		builder.append(idVenda);
		builder.append(", idItemVenda=");
		builder.append(idItemVenda);
		builder.append(", data=");
		builder.append(data);
		builder.append(", loja=");
		builder.append(loja);
		builder.append(", pdv=");
		builder.append(pdv);
		builder.append(", produto=");
		builder.append(produto);
		builder.append(", precoUnitario=");
		builder.append(precoUnitario);
		builder.append(", desconto=");
		builder.append(desconto);
		builder.append(", nomeArquivo=");
		builder.append(nomeArquivo);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_processamento", nullable=false)
    private Long id; 
 
	@Column(name="id_venda")
    private Long idVenda;
	
	@Column(name="id_item_venda")
    private Long idItemVenda;
	
    @Column(name="data")
    private Date data;
    
    @Column(name="loja")
    private int loja; 	
    
    @Column(name="pdv")
    private int pdv;
 
    @Column(name="produto")
    private String produto; 	
    
    @Column(name="preco_unitario")
    private float precoUnitario;
    
    @Column(name="desconto")
    private float desconto;
    
    @Column(name="nome_qrquivo")
    private String nomeArquivo;
    
    @Column(name="status")
    private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getLoja() {
		return loja;
	}

	public void setLoja(int loja) {
		this.loja = loja;
	}

	public int getPdv() {
		return pdv;
	}

	public void setPdv(int pdv) {
		this.pdv = pdv;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}	
}
