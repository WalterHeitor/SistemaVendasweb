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
@Entity
@Table(name="tb_item")
@NamedQueries(
		{@NamedQuery(name="Item.listar", query="SELECT item FROM Item item"),
		@NamedQuery(name="Item.buscarPorCodigo", query="SELECT item FROM Item item "
				+ "WHERE item.codigo_item = :codigo_item")
		})
public class Item {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long codigo_item;
	
	@Column(length=50)
	private Long quant_item;
	
	@Column(scale=2, precision=9)
	private BigDecimal valor_parcial_item;
		
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tb_vendas_codigo_ven", 
	referencedColumnName="codigo_ven", nullable=true)
	private Vendas venda;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tb_produto_codigo_pro", 
	referencedColumnName="codigo_pro", nullable=true)
	private Produto produto;

	public Long getCodigo_item() {
		return codigo_item;
	}

	public void setCodigo_item(Long codigo_item) {
		this.codigo_item = codigo_item;
	}

	public Long getQuant_item() {
		return quant_item;
	}

	public void setQuant_item(Long quant_item) {
		this.quant_item = quant_item;
	}

	public BigDecimal getValor_parcial_item() {
		return valor_parcial_item;
	}

	public void setValor_parcial_item(BigDecimal valor_parcial_item) {
		this.valor_parcial_item = valor_parcial_item;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Vendas getVenda() {
		return venda;
	}

	public void setVenda(Vendas venda) {
		this.venda = venda;
	}

	@Override
	public String toString() {
		return "Item [codigo_item=" + codigo_item + ", quant_item=" + quant_item + ", valor_parcial_item="
				+ valor_parcial_item + ", venda=" + venda + ", produto=" + produto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo_item == null) ? 0 : codigo_item.hashCode());
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
		Item other = (Item) obj;
		if (codigo_item == null) {
			if (other.codigo_item != null)
				return false;
		} else if (!codigo_item.equals(other.codigo_item))
			return false;
		return true;
	}
	
	
	
}
