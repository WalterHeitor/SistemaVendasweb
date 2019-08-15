package br.com.vendas.doumain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;
@Entity
@Table(name="tb_funcionario")
@NamedQueries(
		{@NamedQuery(name="Funcionario.listar", query="SELECT funcionario FROM Funcionario funcionario"),
		@NamedQuery(name="Funcionario.buscarPorCodigo", query="SELECT funcionario FROM Funcionario funcionario "
				+ "WHERE funcionario.codigo_fun = :codigo_fun")
		})
public class Funcionario {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long codigo_fun;
	@NotEmpty(message="Digite nome:")
	@Column(length=50)
	private String nome_fun;
	@NotEmpty(message="Digite senha:")
	@Size(min=5, max=8, message="sua senha deve conter 5 a 8 carateres")
	@Column(length=50)
	private String senha_fun;
	@CPF(message="Cpf Incorreto")
	@Column(length=50, unique=true)
	private String cpf_fun;
	@NotEmpty(message="Digite seu cargo:")
	@Column(length=50)
	private String funcao_fun;
	public Long getCodigo_fun() {
		return codigo_fun;
	}
	public void setCodigo_fun(Long codigo_fun) {
		this.codigo_fun = codigo_fun;
	}
	public String getSenha_fun() {
		return senha_fun;
	}
	public void setSenha_fun(String senha_fun) {
		this.senha_fun = senha_fun;
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
	@Override
	public String toString() {
		return "Funcionario [codigo_fun=" + codigo_fun + ", nome_fun=" + nome_fun + ", senha_fun=" + senha_fun
				+ ", cpf_fun=" + cpf_fun + ", funcao_fun=" + funcao_fun + "]";
	}
	
	
	
}
