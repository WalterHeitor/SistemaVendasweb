package br.com.vendas.beans;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vendas.DAO.FuncionarioDao;
import br.com.vendas.DAO.ProdutoDAO;
import br.com.vendas.DAO.VendasDAO;
import br.com.vendas.doumain.Funcionario;
import br.com.vendas.doumain.Item;
import br.com.vendas.doumain.Produto;
import br.com.vendas.doumain.Vendas;
import br.com.vendas.util.JSFUtil;

@ManagedBean(name = "MBVendas")
@ViewScoped
public class VendasBean {

	private Produto produto;
	private Vendas vendaCadastro;
	private List<Item> itens;
	private List<Item> itensFiltrados;
	
	private List<Produto> produtos;
	private List<Produto> produtosFiltrados;
	
	
	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Vendas getVendaCadastro() {
		if(vendaCadastro == null) {
			vendaCadastro = new Vendas();
			vendaCadastro.setValor_total(new BigDecimal("0.00"));
		}
		return vendaCadastro;
	}


	public void setVendaCadastro(Vendas vendaCadastro) {
		this.vendaCadastro = vendaCadastro;
	}


	public List<Item> getItens() {
		if(itens == null) {
			itens = new ArrayList<>();
		}
		return itens;
	}


	public void setItens(List<Item> itens) {
		this.itens = itens;
	}


	public List<Item> getItensFiltrados() {
		return itensFiltrados;
	}


	public void setItensFiltrados(List<Item> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}


	public List<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}


	public void setProdutosFiltrados(List<Produto> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}


	public void carregarProdutos() {
		try {
			ProdutoDAO fdao = new ProdutoDAO();
			produtos = fdao.listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void adicionarProduto(Produto produto) {
		
		int posicaoEncontrada = -1;
		
		for(int pos=0; pos < itens.size() && posicaoEncontrada < 0; pos++ ) {
			Item itemTemp = itens.get(pos);
			
			if(itemTemp.getProduto().equals(produto)) {
				posicaoEncontrada = pos;
			}
		}
		Item item = new Item();
		item.setProduto(produto);
		
		if(posicaoEncontrada < 0) {	
		item.setQuant_item(1L);
		item.setValor_parcial_item(produto.getPreco_pro());
		itens.add(item);
		}else {	
			Item itemTemp = itens.get(posicaoEncontrada);
			item.setQuant_item(itemTemp.getQuant_item()+1);
			item.setValor_parcial_item(produto.getPreco_pro().multiply(new BigDecimal(itemTemp.getQuant_item())));
			itens.set(posicaoEncontrada, item);
		}
		
		vendaCadastro.setValor_total(vendaCadastro.getValor_total().add( produto.getPreco_pro()));
	}
	
	public void remover(Item item) {
		
		int posicaoEncontrada = -1;
		
		for(int pos=0; pos < itens.size() && posicaoEncontrada < 0; pos++ ) {
			Item itemTemp = itens.get(pos);
			
			if(itemTemp.getProduto().equals(item.getProduto())) {
				posicaoEncontrada = pos;
			}
		}
		
		if(posicaoEncontrada > -1) {
			itens.remove(posicaoEncontrada);
			vendaCadastro.setValor_total(vendaCadastro.getValor_total().subtract(item.getValor_parcial_item()));
		}
	}
	
	public void carregarDadosVenda() {
		vendaCadastro.setHorario_ven(new Date());
		FuncionarioDao fdao = new FuncionarioDao();
		Funcionario funcionario = fdao.buscarPorCodigo(58L);
		vendaCadastro.setFuncionario(funcionario);
	}
	public void salvar() {
		try {
			VendasDAO vdao = new VendasDAO();
			vdao.salvar(vendaCadastro);
			
			vendaCadastro = new Vendas();
			vendaCadastro.setValor_total(new BigDecimal("0.00"));
			itens = new ArrayList<>();
			
			JSFUtil.addMensagemSucesso("Salvo com succeso!!!");
		} catch (Exception e) {
			JSFUtil.addMensagemErro("e.getMessage()");
			e.printStackTrace();
		}
	}
	
	
}//fim classe
