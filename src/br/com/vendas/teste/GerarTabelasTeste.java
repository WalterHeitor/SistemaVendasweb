package br.com.vendas.teste;

import org.junit.Test;

import br.com.vendas.util.HibernateUtil;

public class GerarTabelasTeste {
	@Test
	public void gerar() {
		HibernateUtil.getSessionFactory().openSession();
		HibernateUtil.getSessionFactory().close();
	}
}
