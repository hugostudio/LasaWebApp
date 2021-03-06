package br.com.lasa.mvc.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonFormat;
 

@Entity(name="tb_venda")
public class Venda {

	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_venda", nullable=false)
    private Long id; 
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name="data", nullable=false)    
    private Date data;
    
    @Column(name="loja", nullable=false)
    private int loja; 	
    
    @Column(name="pdv", nullable=false)
    private int pdv;
    
    @Column(name="status", columnDefinition="varchar(14) default 'NÃO PROCESSADO'")
    private String status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_venda", updatable = true, insertable = true)
    private List<ItemVenda> itens;
    
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Venda [id=");
		builder.append(id);
		builder.append(", data=");
		builder.append(data);
		builder.append(", loja=");
		builder.append(loja);
		builder.append(", pdv=");
		builder.append(pdv);
		builder.append(", status=");
		builder.append(status);
		builder.append(", itens=");
		builder.append(itens);
		builder.append("]");
		return builder.toString();
	}

}
