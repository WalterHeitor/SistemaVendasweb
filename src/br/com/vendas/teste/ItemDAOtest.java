package br.com.vendas.teste;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import br.com.vendas.DAO.ItemDAO;
import br.com.vendas.DAO.ProdutoDAO;
import br.com.vendas.DAO.VendasDAO;
import br.com.vendas.doumain.Item;
import br.com.vendas.doumain.Produto;
import br.com.vendas.doumain.Vendas;

public class ItemDAOtest {
	
	public void salvar() {
		VendasDAO vdao = new VendasDAO();
		Vendas v = vdao.buscarPorCodigo(33L);		
		ProdutoDAO pdao = new ProdutoDAO();
		Produto p = pdao.buscarPorCodigo(30L);	
		Item i = new Item();
		i.setQuant_item(14L);
		i.setValor_parcial_item(new BigDecimal(86D));
		i.setProduto(p);
		i.setVenda(v);
		ItemDAO itemDAO = new ItemDAO();
		itemDAO.salvar(i);	
	}
	
	public void listar() {
		ItemDAO itemDAO = new ItemDAO();
		List<Item>items = itemDAO.listar();
		for (Item item: items) {
			System.out.println(item);
		}
	}
	
	public void buscarPorCodigo() {
		ItemDAO itemDAO = new ItemDAO();
		Item i = itemDAO.buscarPorCodigo(38L);
		System.out.println(i);
	}

	public void excluir() {
		ItemDAO itemDAO = new ItemDAO();
		Item i = itemDAO.buscarPorCodigo(38L);
		itemDAO.excluir(i);
	}
	@Test
	public void editar() {
		VendasDAO vdao = new VendasDAO();
		Vendas v = vdao.buscarPorCodigo(33L);		
		ProdutoDAO pdao = new ProdutoDAO();
		Produto p = pdao.buscarPorCodigo(30L);	
		ItemDAO idao = new ItemDAO();
		Item i = idao.buscarPorCodigo(37L);
		i.setQuant_item(140L);
		i.setValor_parcial_item(new BigDecimal(806D));
		i.setProduto(p);
		i.setVenda(v);
		ItemDAO itemDAO = new ItemDAO();
		itemDAO.editar1(i);
	}
	
}
