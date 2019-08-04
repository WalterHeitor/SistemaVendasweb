package br.com.vendas.doumain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_fornecedor")
public class Fornecedor {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long codigo_for;
	@Column(length=50)
	private String descricao_for;
	
	public Long getCodigo_for() {
		return codigo_for;
	}
	public void setCodigo_for(Long codigo_for) {
		this.codigo_for = codigo_for;
	}
	public String getDescricao_for() {
		return descricao_for;
	}
	public void setDescricao_for(String descricao_for) {
		this.descricao_for = descricao_for;
	}

	
}
