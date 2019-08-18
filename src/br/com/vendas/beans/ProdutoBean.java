package br.com.vendas.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vendas.DAO.FornecedoresDAO;
import br.com.vendas.DAO.ProdutoDAO;
import br.com.vendas.doumain.Fornecedor;
import br.com.vendas.doumain.Produto;
import br.com.vendas.util.JSFUtil;
@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {
	private Produto produto;
	private List<Produto> itens;
	private List<Produto> itensFiltrados;
	private String acao;
	private Long codigo;
	private List<Fornecedor>listaFornecedor;
	
	
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public List<Produto> getItens() {
		return itens;
	}
	public void setItens(List<Produto> itens) {
		this.itens = itens;
	}
	public List<Produto> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(List<Produto> itensFiltrados) {
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
	public List<Fornecedor> getListaFornecedor() {
		return listaFornecedor;
	}
	public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
		this.listaFornecedor = listaFornecedor;
	}
		// @PostConstruct
		public void prepararPesquisa() {
			try {
				ProdutoDAO fdao = new ProdutoDAO();
				itens = fdao.listar();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		public void carregarCadastro() {
			try {
				acao = JSFUtil.getParam("proacao");
				String valor = JSFUtil.getParam("procad");
		
				if (valor != null) {
					codigo = Long.parseLong(valor); 
					ProdutoDAO pdao = new ProdutoDAO();
					produto = pdao.buscarPorCodigo(codigo);
				} else {
					produto = new Produto();
				}
				FornecedoresDAO fdao = new FornecedoresDAO();
				 listaFornecedor = fdao.listar();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		public void salvar() {
			try {
				ProdutoDAO fdao = new ProdutoDAO();
				System.out.println(produto);
				fdao.salvar(produto);
				JSFUtil.addMensagemSucesso("Produto salvo com Sucesso!!!");
				produto = new Produto();
			} catch (Exception e) {
				JSFUtil.addMensagemErro("erro ao salvar: e.getMessage() " + e.getMessage());
			}
		}

		public void excluir() {
			try {
				ProdutoDAO fdao = new ProdutoDAO();
				fdao.excluir(produto);
				JSFUtil.addMensagemSucesso("Produto deletado com Sucesso!!!");
			} catch (Exception e) {
				JSFUtil.addMensagemErro("erro ao deletar: e.getMessage() " + e.getMessage());
			}
		}

		public void editar() {
			try {
				ProdutoDAO fdao = new ProdutoDAO();
				fdao.editar1(produto);
				JSFUtil.addMensagemSucesso("Produto editado com Sucesso!!!");
			} catch (Exception e) {
				JSFUtil.addMensagemErro("erro ao editar: e.getMessage() " + e.getMessage());
			}
		}
}
