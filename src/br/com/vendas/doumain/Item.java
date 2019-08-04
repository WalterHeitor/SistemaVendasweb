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
import javax.persistence.Table;
@Entity
@Table(name="tb_item")
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
	
	
}
