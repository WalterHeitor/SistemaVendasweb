package br.com.vendas.teste;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.vendas.DAO.FuncionarioDao;
import br.com.vendas.DAO.VendasDAO;
import br.com.vendas.doumain.Funcionario;
import br.com.vendas.doumain.Vendas;

public class VendasDAOteste {
	
	public void salvar() {
			
		FuncionarioDao fdao = new FuncionarioDao();
		Funcionario f = fdao.buscarPorCodigo(25L);
		Vendas v = new Vendas();
		v.setHorario_ven(new Date());
		v.setValor_total(new BigDecimal(89D));
		v.setFuncionario(f);
		VendasDAO vdao = new VendasDAO();
		vdao.salvar(v);
		
	}
	
	public void listar() {
		VendasDAO vdao = new VendasDAO();
		List<Vendas>vendas = vdao.listar();
		for(Vendas v : vendas) {
			System.out.println(v);
		}
	}
	
	public void buscarporcodigo() {
		VendasDAO vdao = new VendasDAO();
		Vendas v = vdao.buscarPorCodigo(34L);
		System.out.println(v);
	}

	public void excluir() {
		VendasDAO vdao = new VendasDAO();
		Vendas v = vdao.buscarPorCodigo(34L);
		vdao.excluir(v);
	}
	@Test
	public void editar() {
		FuncionarioDao fdao = new FuncionarioDao();
		Funcionario funcionario = fdao.buscarPorCodigo(27L);
		VendasDAO vdao = new VendasDAO();
		Vendas v = vdao.buscarPorCodigo(35L);
		v.setHorario_ven(new Date());
		v.setValor_total(new BigDecimal(120D));
		v.setFuncionario(funcionario);
		vdao.editar1(v);
		
	}
	
	
	
	
}
