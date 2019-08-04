package br.com.vendas.doumain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tb_funcionario")
public class Funcionario {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long codigo_fun;
	@Column(length=50)
	private String descricao_fun;
	@Column(length=50)
	private String nome_fun;
	@Column(length=50, unique=true)
	private String cpf_fun;
	@Column(length=50)
	private String funcao_fun;
	public Long getCodigo_fun() {
		return codigo_fun;
	}
	public void setCodigo_fun(Long codigo_fun) {
		this.codigo_fun = codigo_fun;
	}
	public String getDescricao_fun() {
		return descricao_fun;
	}
	public void setDescricao_fun(String descricao_fun) {
		this.descricao_fun = descricao_fun;
	}
	public String getNome_fun() {
		return nome_fun;
	}
	public void setNome_fun(String nome_fun) {
		this.nome_fun = nome_fun;
	}
	public String getCpf_fun() {
		return cpf_fun;
	}
	public void setCpf_fun(String cpf_fun) {
		this.cpf_fun = cpf_fun;
	}
	public String getFuncao_fun() {
		return funcao_fun;
	}
	public void setFuncao_fun(String funcao_fun) {
		this.funcao_fun = funcao_fun;
	}
	
	
}
