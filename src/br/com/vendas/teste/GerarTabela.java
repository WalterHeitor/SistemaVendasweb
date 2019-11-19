package br.com.vendas.teste;

import org.junit.Test;

import br.com.vendas.DAO.FornecedoresDAO;
import br.com.vendas.doumain.Fornecedor;
import br.com.vendas.util.HibernateUtil;

public class GerarTabela {
	@Test
	public static void main(String[] args) {
		criarTabelas();
		//salvar();
	}
	public static void salvar() {
		Fornecedor f1 = new Fornecedor();
		
		f1.setDescricao_for("Descriçao 2");
		System.out.println("prencheu fornecedor");

		FornecedoresDAO fdao = new FornecedoresDAO();

		fdao.salvar(f1);
		System.out.println("chama metodo salvar");
	}
	public static void criarTabelas() {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}

}
