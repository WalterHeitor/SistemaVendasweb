package br.com.vendas.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vendas.DAO.FornecedoresDAO;
import br.com.vendas.doumain.Fornecedor;
import br.com.vendas.util.JSFUtil;

@ManagedBean(name = "MBFornecedores")
@ViewScoped
public class FornecedoresBean {

	private Fornecedor fornecedor;
	private List<Fornecedor> itens;
	private List<Fornecedor> itensFiltrados;
	private String acao;
	private Long codigo;

	public Fornecedor getFornecedor() {

		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getItens() {
		return itens;
	}

	public void setItens(List<Fornecedor> itens) {
		this.itens = itens;
	}

	public List<Fornecedor> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(List<Fornecedor> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	// @PostConstruct
	public void prepararPesquisa() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			itens = fdao.listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void carregarCadastro() {
		try {
			acao = JSFUtil.getParam("foracao");
			String valor = JSFUtil.getParam("forcad");
			
			if (valor != null) {
				codigo = Long.parseLong(valor); 
				FornecedoresDAO fdao = new FornecedoresDAO();
				fornecedor = fdao.buscarPorCodigo(codigo);
			} else {
				fornecedor = new Fornecedor();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void salvar() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.salvar(fornecedor);
			JSFUtil.addMensagemSucesso("Fornecedor salvo com Sucesso!!!");
			fornecedor = new Fornecedor();
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao salvar: e.getMessage() " + e.getMessage());
		}
	}

	public void excluir() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.excluir(fornecedor);
			JSFUtil.addMensagemSucesso("Fornecedor deletado com Sucesso!!!");
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao deletar: e.getMessage() " + e.getMessage());
		}
	}

	public void editar() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.editar1(fornecedor);
			JSFUtil.addMensagemSucesso("Fornecedor editado com Sucesso!!!");
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao editar: e.getMessage() " + e.getMessage());
		}
	}

}
