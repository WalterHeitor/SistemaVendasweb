package br.com.vendas.doumain;
import java.math.BigDecimal;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_vendas")
@NamedQueries(
		{@NamedQuery(name="Vendas.listar", query="SELECT venda FROM Vendas venda"),
		@NamedQuery(name="Vendas.buscarPorCodigo", query="SELECT venda FROM Vendas venda "
				+ "WHERE venda.codigo_ven = :codigo_ven")
		})
public class Vendas {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long codigo_ven;
	
	@Column
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date horario_ven;
	
	@Column	
	private BigDecimal valor_total;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tb_funcionario_codigo_fun", 
	referencedColumnName="codigo_fun", nullable=true)
	Funcionario funcionario;

	public Long getCodigo_ven() {
		return codigo_ven;
	}

	public void setCodigo_ven(Long codigo_ven) {
		this.codigo_ven = codigo_ven;
	}

	public Date getHorario_ven() {
		return horario_ven;
	}

	public void setHorario_ven(Date horario_ven) {
		this.horario_ven = horario_ven;
	}

	public BigDecimal getValor_total() {
		return valor_total;
	}

	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Vendas [codigo_ven=" + codigo_ven + ", horario_ven=" + horario_ven + ", valor_total=" + valor_total
				+ ", funcionario=" + funcionario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo_ven == null) ? 0 : codigo_ven.hashCode());
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
		Vendas other = (Vendas) obj;
		if (codigo_ven == null) {
			if (other.codigo_ven != null)
				return false;
		} else if (!codigo_ven.equals(other.codigo_ven))
			return false;
		return true;
	}
	
	
}
