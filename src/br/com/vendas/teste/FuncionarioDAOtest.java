package br.com.vendas.teste;

import java.util.List;

import org.junit.Test;
import br.com.vendas.DAO.FuncionarioDao;
import br.com.vendas.doumain.Funcionario;

public class FuncionarioDAOtest {
	
	public void salvar() {
		Funcionario fun1 = new Funcionario();
		fun1.setDescricao_fun("bonita");
		fun1.setNome_fun("nicolas");
		fun1.setCpf_fun("12324562");
		fun1.setFuncao_fun("gerente");
		FuncionarioDao fdao = new FuncionarioDao();
		fdao.salvar(fun1);
	}
	
	public void listar() {
		FuncionarioDao fdao = new FuncionarioDao();
		List<Funcionario>funcionarios = fdao.listar();		
		for(Funcionario funcionario: funcionarios) {
			System.out.println(funcionario);
		}
	}
	
	public void buscarPorCodigo() {
		FuncionarioDao fdao = new FuncionarioDao();
		Funcionario f1=fdao.buscarPorCodigo(26L);
		System.out.println(f1);
	}
	
	public void excluir() {
		FuncionarioDao fdao = new FuncionarioDao();
		Funcionario f1 = fdao.buscarPorCodigo(26L);
		if(f1 != null) {
		fdao.excluir(f1);
		}
	}
	@Test
	public void editar() {
		Funcionario f1=new Funcionario();
		f1.setCodigo_fun(27L);
		f1.setDescricao_fun("bonita");
		f1.setNome_fun("maria Elisabet");
		f1.setCpf_fun("12345678");
		f1.setFuncao_fun("almaxarife");
		FuncionarioDao fdao = new FuncionarioDao();
		fdao.editar1(f1);
	}
	
	
}
