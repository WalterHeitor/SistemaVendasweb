package br.com.vendas.DAO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.vendas.doumain.Funcionario;
import br.com.vendas.util.HibernateUtil;

public class FuncionarioDao {
	public void salvar(Funcionario funcionario) {
		//criando a conexao
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("criou a conexao");		
		Transaction transaction = null;		
		try {
			transaction = session.beginTransaction();//abrindo a transaçao			
			session.save(funcionario);
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
	public List<Funcionario>listar(){
		//criando a conexao
				Session sessao = HibernateUtil.getSessionFactory().openSession();
				System.out.println("criou a conexao");				
				List<Funcionario>funcionarios=null;				
				try {
					Query	consulta = 	sessao.getNamedQuery("Funcionario.listar");
					funcionarios = consulta.list();
					System.out.println("listado com sucesso");					
				} catch (RuntimeException e) {						
					System.out.println("erro ao salvar "+e.getMessage());
					throw e;
				}
				finally {
					sessao.close();
				}
				return funcionarios;
	}
	
	public Funcionario buscarPorCodigo(Long codigo_fun){
		//criando a conexao
				Session sessao = HibernateUtil.getSessionFactory().openSession();
				System.out.println("criou a conexao");				
				Funcionario funcionario = null;				
				try {
					Query	consulta = 	sessao.getNamedQuery("Funcionario.buscarPorCodigo");
					consulta.setLong("codigo_fun", codigo_fun);
					funcionario = (Funcionario) consulta.uniqueResult();
					System.out.println("buscado com sucesso");
					
				} catch (RuntimeException e) {						
					System.out.println("erro ao salvar "+e.getMessage());
					throw e;
				}
				finally {
					sessao.close();
				}
				return funcionario;
	}
	
	public void excluir(Funcionario funcionario) {
		//criando a conexao
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("criou a conexao");		
		Transaction transaction = null;		
		try {
			transaction = session.beginTransaction();//abrindo a transaçao			
			session.delete(funcionario);
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
			Funcionario funcionario = buscarPorCodigo(codigo);
			session.delete(funcionario);
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
	
	public void editar(Funcionario funcionario) {
		//criando a conexao
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("criou a conexao");		
		Transaction transaction = null;		
		try {
			transaction = session.beginTransaction();//abrindo a transaçao			
			Funcionario funcionarioEditar = buscarPorCodigo(funcionario.getCodigo_fun());
			funcionarioEditar.setDescricao_fun(funcionario.getDescricao_fun());
			funcionarioEditar.setNome_fun(funcionario.getNome_fun());
			funcionarioEditar.setCpf_fun(funcionario.getCpf_fun());
			funcionarioEditar.setFuncao_fun(funcionario.getFuncao_fun());
			session.update(funcionarioEditar);
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
	
	public void editar1(Funcionario funcionario) {
		//criando a conexao
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("criou a conexao");	
		Transaction transaction = null;	
		try {
			transaction = session.beginTransaction();//abrindo a transaçao			
			session.update(funcionario);
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
