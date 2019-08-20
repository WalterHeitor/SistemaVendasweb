package br.com.vendas.doumain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="tb_fornecedor")
@NamedQueries(
		{@NamedQuery(name="Fornecedor.listar", query="SELECT fornecedor FROM Fornecedor fornecedor"),
		@NamedQuery(name="Fornecedor.buscarPorCodigo", query="SELECT fornecedor FROM Fornecedor fornecedor "
				+ "WHERE fornecedor.codigo_for = :codigo_for")
		})
public class Fornecedor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Long codigo_for;
	@NotEmpty(message="Insira a descriçao")
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
	@Override
	public String toString() {
		return "Fornecedor [codigo_for=" + codigo_for + ", descricao_for=" + descricao_for + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo_for == null) ? 0 : codigo_for.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (codigo_for == null) {
			if (other.codigo_for != null)
				return false;
		} else if (!codigo_for.equals(other.codigo_for))
			return false;
		return true;
	}
	
	
	
}
