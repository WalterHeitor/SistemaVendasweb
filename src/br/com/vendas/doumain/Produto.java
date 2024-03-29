package br.com.vendas.doumain;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tb_produto")
@NamedQueries(
		{@NamedQuery(name="Produto.listar", query="SELECT produto FROM Produto produto"),
		@NamedQuery(name="Produto.buscarPorCodigo", query="SELECT produto FROM Produto produto "
				+ "WHERE produto.codigo_pro = :codigo_pro")
		})
public class Produto {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long codigo_pro;
	@NotEmpty(message="Digite a descri��o:")
	@Column(length=50)
	private String descricao_pro;
	@NotNull(message="Insira um valor")
	@Min(value= 0,message="O valor deve ser maior que zero")
	@Column(scale=2, precision=9)
	private BigDecimal preco_pro;
	
	@Column
	private Long quant_pro;
	@NotNull(message="selecione o fornecdor")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tb_fornecedor_codigo_for", 
	referencedColumnName="codigo_for", nullable=true)
	private Fornecedor fornecedor;

	public Long getCodigo_pro() {
		return codigo_pro;
	}

	public void setCodigo_pro(Long codigo_pro) {
		this.codigo_pro = codigo_pro;
	}

	public String getDescricao_pro() {
		return descricao_pro;
	}

	public void setDescricao_pro(String descricao_pro) {
		this.descricao_pro = descricao_pro;
	}

	public BigDecimal getPreco_pro() {
		return preco_pro;
	}

	public void setPreco_pro(BigDecimal preco_pro) {
		this.preco_pro = preco_pro;
	}

	public Long getQuant_pro() {
		return quant_pro;
	}

	public void setQuant_pro(Long quant_pro) {
		this.quant_pro = quant_pro;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		return "Produto [codigo_pro=" + codigo_pro + ", descricao_pro=" + descricao_pro + ", preco_pro=" + preco_pro
				+ ", quant_pro=" + quant_pro + ", fornecedor=" + fornecedor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo_pro == null) ? 0 : codigo_pro.hashCode());
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
		Produto other = (Produto) obj;
		if (codigo_pro == null) {
			if (other.codigo_pro != null)
				return false;
		} else if (!codigo_pro.equals(other.codigo_pro))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
}
