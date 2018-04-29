package br.com.lasa.mvc.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 

@Entity(name="tb_venda")
public class Venda {
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_venda", nullable=false)
    private Long id; 
    
    @Column(name="data", nullable=false)
    private Date data;
    
    @Column(name="loja", nullable=false)
    private int loja; 	
    
    @Column(name="pdv", nullable=false)
    private int pdv;
    
    @Column(name="status", nullable=false)
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
