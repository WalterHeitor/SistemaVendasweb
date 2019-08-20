package br.com.vendas.teste;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DecimalDV;

import br.com.vendas.DAO.FornecedoresDAO;
import br.com.vendas.DAO.ProdutoDAO;
import br.com.vendas.doumain.Fornecedor;
import br.com.vendas.doumain.Produto;

public class ProdutoDAOtest {
	@Test
	public void salvar() {
		FornecedoresDAO fdao = new FornecedoresDAO();
		Fornecedor f1 = fdao.buscarPorCodigo(51L);
		Produto p1 = new Produto();
		p1.setDescricao_pro("sabão");
		p1.setPreco_pro(new BigDecimal(1.47D));
		p1.setQuant_pro(5L);
		p1.setFornecedor(f1);
		ProdutoDAO pdao = new ProdutoDAO();
		pdao.salvar(p1);
	}
	
	public void listar() {
		ProdutoDAO pdao = new ProdutoDAO();
		List<Produto>produtos = pdao.listar();
		
		for(Produto produto: produtos) {
			System.out.println(produto);
		}
	}
	
	public void buscarPorCodigo() {
		ProdutoDAO pdao = new ProdutoDAO();
		Produto p1 = 
				pdao.buscarPorCodigo(29L);
		System.out.println(p1);
		
	}
	
	public void excluir() {
		ProdutoDAO pdao = new ProdutoDAO();
		Produto p1 = 
				pdao.buscarPorCodigo(29L);
		if(p1 != null) {
		pdao.excluir(p1);
		}
	}
	
	public void editar() {
		FornecedoresDAO fdao = new FornecedoresDAO();
		Fornecedor f = fdao.buscarPorCodigo(21L);
		ProdutoDAO pdao = new ProdutoDAO();
		Produto p = pdao.buscarPorCodigo(31L);
		p.setDescricao_pro("abacate");
		p.setPreco_pro(new BigDecimal(10.99D));
		p.setQuant_pro(3L);
		p.setFornecedor(f);
		pdao.editar1(p);
	}
	
}
