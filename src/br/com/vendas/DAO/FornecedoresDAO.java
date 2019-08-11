package br.com.vendas.DAO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.vendas.doumain.Fornecedor;
import br.com.vendas.util.HibernateUtil;

public class FornecedoresDAO {
	public void salvar(Fornecedor fornecedor) {
		//criando a conexao
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("criou a conexao");		
		Transaction transaction = null;		
		try {
			transaction = session.beginTransaction();//abrindo a transaçao			
			session.save(fornecedor);
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
	public List<Fornecedor>listar(){
		//criando a conexao
				Session sessao = HibernateUtil.getSessionFactory().openSession();
				System.out.println("criou a conexao");				
				List<Fornecedor>fornecedores=null;				
				try {
					Query	consulta = 	sessao.getNamedQuery("Fornecedor.listar");
					fornecedores = consulta.list();
					System.out.println("listado com sucesso");					
				} catch (RuntimeException e) {						
					System.out.println("erro ao salvar "+e.getMessage());
					throw e;
				}
				finally {
					sessao.close();
				}
				return fornecedores;
	}
	
	public Fornecedor buscarPorCodigo(Long codigo_for){
		//criando a conexao
				Session sessao = HibernateUtil.getSessionFactory().openSession();
				System.out.println("criou a conexao");				
				Fornecedor fornecedor = null;				
				try {
					Query	consulta = 	sessao.getNamedQuery("Fornecedor.buscarPorCodigo");
					consulta.setLong("codigo_for", codigo_for);
					fornecedor = (Fornecedor) consulta.uniqueResult();
					System.out.println("buscado com sucesso");
					
				} catch (RuntimeException e) {						
					System.out.println("erro ao salvar "+e.getMessage());
					throw e;
				}
				finally {
					sessao.close();
				}
				return fornecedor;
	}
	
	public void excluir(Fornecedor fornecedor) {
		//criando a conexao
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("criou a conexao");		
		Transaction transaction = null;	
		try {
			transaction = session.beginTransaction();//abrindo a transaçao			
			session.delete(fornecedor);
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
			Fornecedor fornecedor = buscarPorCodigo(codigo);
			session.delete(fornecedor);
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
	
	public void editar(Fornecedor fornecedor) {
		//criando a conexao
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("criou a conexao");		
		Transaction transaction = null;		
		try {
			transaction = session.beginTransaction();//abrindo a transaçao			
			Fornecedor fornecedorEditar = buscarPorCodigo(fornecedor.getCodigo_for());
			fornecedorEditar.setDescricao_for(fornecedor.getDescricao_for());
			session.update(fornecedorEditar);
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
	public void editar1(Fornecedor fornecedor) {
		//criando a conexao
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("criou a conexao");		
		Transaction transaction = null;		
		try {
			transaction = session.beginTransaction();//abrindo a transaçao			
			session.update(fornecedor);
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
