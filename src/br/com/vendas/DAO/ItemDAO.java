package br.com.vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.vendas.doumain.Item;
import br.com.vendas.util.HibernateUtil;

public class ItemDAO {
	public void salvar(Item item) {
		//criando a conexao
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("criou a conexao");
		
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();//abrindo a transaçao			
			session.save(item);
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
	public List<Item>listar(){
		//criando a conexao
				Session sessao = HibernateUtil.getSessionFactory().openSession();
				System.out.println("criou a conexao");
				
				List<Item>itens=null;
				
				try {
					Query	consulta = 	sessao.getNamedQuery("Item.listar");
					itens = consulta.list();
					System.out.println("listado com sucesso");
					
				} catch (RuntimeException e) {						
					System.out.println("erro ao salvar "+e.getMessage());
					throw e;
				}
				finally {
					sessao.close();
				}
				return itens;
	}
	public Item buscarPorCodigo(Long codigo_item){
		//criando a conexao
				Session sessao = HibernateUtil.getSessionFactory().openSession();
				System.out.println("criou a conexao");
				
				Item item = null;
				
				try {
					Query	consulta = 	sessao.getNamedQuery("Item.buscarPorCodigo");
					consulta.setLong("codigo_item", codigo_item);
					item = (Item) consulta.uniqueResult();
					System.out.println("buscado com sucesso");
					
				} catch (RuntimeException e) {						
					System.out.println("erro ao salvar "+e.getMessage());
					throw e;
				}
				finally {
					sessao.close();
				}
				return item;
	}
	public void excluir(Item item) {
		//criando a conexao
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("criou a conexao");
		
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();//abrindo a transaçao			
			session.delete(item);
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
			Item item = buscarPorCodigo(codigo);
			session.delete(item);
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
	public void editar1(Item item) {
		//criando a conexao
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("criou a conexao");
		
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();//abrindo a transaçao			
			session.update(item);
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
