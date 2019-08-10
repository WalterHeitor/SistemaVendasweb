package br.com.vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.vendas.doumain.Produto;
import br.com.vendas.util.HibernateUtil;

public class ProdutoDAO {

	public void salvar(Produto produto) {
		//criando a conexao
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("criou a conexao");		
		Transaction transaction = null;		
		try {
			transaction = session.beginTransaction();//abrindo a transaçao			
			session.save(produto);
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
	public List<Produto>listar(){
		//criando a conexao
				Session sessao = HibernateUtil.getSessionFactory().openSession();
				System.out.println("criou a conexao");				
				List<Produto>produtos=null;				
				try {
					Query	consulta = 	sessao.getNamedQuery("Produto.listar");
					produtos = consulta.list();
					System.out.println("listado com sucesso");					
				} catch (RuntimeException e) {						
					System.out.println("erro ao salvar "+e.getMessage());
					throw e;
				}
				finally {
					sessao.close();
				}
				return produtos;
	}
	
	public Produto buscarPorCodigo(Long codigo_pro){
		//criando a conexao
				Session sessao = HibernateUtil.getSessionFactory().openSession();
				System.out.println("criou a conexao");				
				Produto produto = null;				
				try {
					Query	consulta = 	sessao.getNamedQuery("Produto.buscarPorCodigo");
					consulta.setLong("codigo_pro", codigo_pro);
					produto = (Produto) consulta.uniqueResult();
					System.out.println("buscado com sucesso");
					
				} catch (RuntimeException e) {						
					System.out.println("erro ao salvar "+e.getMessage());
					throw e;
				}
				finally {
					sessao.close();
				}
				return produto;
	}
	
	public void excluir(Produto produto) {
		//criando a conexao
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("criou a conexao");		
		Transaction transaction = null;		
		try {
			transaction = session.beginTransaction();//abrindo a transaçao			
			session.delete(produto);
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
			Produto produto = buscarPorCodigo(codigo);
			session.delete(produto);
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
	
	public void editar(Produto produto) {
		//criando a conexao
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("criou a conexao");		
		Transaction transaction = null;		
		try {
			transaction = session.beginTransaction();//abrindo a transaçao			
			Produto produtoEditar = buscarPorCodigo(produto.getCodigo_pro());;
			
			session.update(produtoEditar);
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
	
	public void editar1(Produto produto) {
		//criando a conexao
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("criou a conexao");	
		Transaction transaction = null;	
		try {
			transaction = session.beginTransaction();//abrindo a transaçao			
			session.update(produto);
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
