package br.com.vendas.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Contextlistener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtil.getSessionFactory().close();
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		HibernateUtil.getSessionFactory().openSession();
		
	}

}
