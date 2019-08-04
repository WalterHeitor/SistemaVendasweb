package br.com.vendas.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vendas.doumain.Fornecedor;
import br.com.vendas.util.HibernateUtil;

public class FornecedoresDAO {

	public void salvar(Fornecedor fornecedor) {
		//criando a conexao
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();//abrindo a transaçao
			session.save(fornecedor);
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
