package br.com.vendas.teste;

import java.util.List;

import org.junit.Test;

import br.com.vendas.DAO.FornecedoresDAO;
import br.com.vendas.doumain.Fornecedor;

public class FornecedorDAOtest {
	
	public void salvar() {
		Fornecedor f1 = new Fornecedor();
		f1.setDescricao_for("Descriçao 6");

		FornecedoresDAO fdao = new FornecedoresDAO();

		fdao.salvar(f1);
	}
	
	public void listar() {
		FornecedoresDAO fdao = new FornecedoresDAO();
		List<Fornecedor>fornecedores = fdao.listar();
		
		for(Fornecedor fornecedor: fornecedores) {
			System.out.println(fornecedor);
		}
	}
	
	public void buscarPorCodigo() {
		FornecedoresDAO fdao = new FornecedoresDAO();
		Fornecedor f1 = 
				fdao.buscarPorCodigo(18L);
		System.out.println(f1);
		
	}
	
	public void excluir() {
		FornecedoresDAO fdao = new FornecedoresDAO();
		Fornecedor f1 = fdao.buscarPorCodigo(18L);
		if(f1 != null) {
		fdao.excluir(f1);
		}
	}
	
	public void excluirPorCodigo() {
		FornecedoresDAO fdao = new FornecedoresDAO();		
		fdao.excluir(20L);		
	}
	@Test
	public void editar() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setCodigo_for(21L);
		fornecedor.setDescricao_for("walter heitor");
		FornecedoresDAO fdao = new FornecedoresDAO();		
		fdao.editar(fornecedor);		
	}
	
	
}
