package br.com.vendas.teste;

import org.junit.Test;

import br.com.vendas.util.HibernateUtil;

public class GerarTabela {
	@Test
	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();

	}

}
