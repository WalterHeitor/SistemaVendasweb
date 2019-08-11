package br.com.vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.vendas.doumain.Vendas;
import br.com.vendas.util.HibernateUtil;
public class VendasDAO {
	public void salvar(Vendas venda) {
		//criando a conexao
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("criou a conexao");
		
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();//abrindo a transaçao			
			session.save(venda);
			transaction.commit();//confirmando a transaçao
			System.out.println("salvo com sucesso");
			
		} catch (RuntimeException e) {
			if(transaction != null) {
				transaction.rollback();				
			}	
			System.out.println("erro ao salvar "+e.getMessage());			
		}
		finally {
			session.close();
		}
		
	}
	@SuppressWarnings("unchecked")
	public List<Vendas>listar(){
		//criando a conexao
				Session sessao = HibernateUtil.getSessionFactory().openSession();
				System.out.println("criou a conexao");
				
				List<Vendas>vendas=null;
				
				try {
					Query	consulta = 	sessao.getNamedQuery("Vendas.listar");
					vendas = consulta.list();
					System.out.println("listado com sucesso");
					
				} catch (RuntimeException e) {						
					System.out.println("erro ao salvar "+e.getMessage());
					throw e;
				}
				finally {
					sessao.close();
				}
				return vendas;
	}
	public Vendas buscarPorCodigo(Long codigo_ven){
		//criando a conexao
				Session sessao = HibernateUtil.getSessionFactory().openSession();
				System.out.println("criou a conexao");
				
				Vendas venda = null;
				
				try {
					Query	consulta = 	sessao.getNamedQuery("Vendas.buscarPorCodigo");
					consulta.setLong("codigo_ven", codigo_ven);
					venda = (Vendas) consulta.uniqueResult();
					System.out.println("buscado com sucesso");
					
				} catch (RuntimeException e) {						
					System.out.println("erro ao salvar "+e.getMessage());
					throw e;
				}
				finally {
					sessao.close();
				}
				return venda;
	}
	public void excluir(Vendas venda) {
		//criando a conexao
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("criou a conexao");
		
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();//abrindo a transaçao			
			session.delete(venda);
			transaction.commit();//confirmando a transaçao
			System.out.println("deletado com sucesso");
			
		} catch (RuntimeException e) {
			if(transaction != null) {
				transaction.rollback();				
			}	
			System.out.println("erro ao salvar "+e.getMessage());			
		}
		finally {
			session.close();
		}
		
	}
	public void excluir(Long codigo) {
		//criando a conexao
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("criou a conexao");
		
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();//abrindo a transaçao			
			Vendas venda = buscarPorCodigo(codigo);
			session.delete(venda);
			transaction.commit();//confirmando a transaçao
			System.out.println("deletado com sucesso");
			
		} catch (RuntimeException e) {
			if(transaction != null) {
				transaction.rollback();				
			}	
			System.out.println("erro ao salvar "+e.getMessage());			
		}
		finally {
			session.close();
		}
	}
	public void editar1(Vendas venda) {
		//criando a conexao
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("criou a conexao");
		
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();//abrindo a transaçao			
			session.update(venda);
			transaction.commit();//confirmando a transaçao
			System.out.println("editado com sucesso");
			
		} catch (RuntimeException e) {
			if(transaction != null) {
				transaction.rollback();				
			}	
			System.out.println("erro ao editar "+e.getMessage());			
		}
		finally {
			session.close();
		}
		
	}
}
