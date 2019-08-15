package br.com.vendas.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vendas.DAO.FornecedoresDAO;
import br.com.vendas.DAO.FuncionarioDao;
import br.com.vendas.doumain.Fornecedor;
import br.com.vendas.doumain.Funcionario;
import br.com.vendas.util.JSFUtil;

@ManagedBean(name = "MBFuncionario")
@ViewScoped
public class FuncionariosBean {

	private Funcionario funcionario;
	private List<Funcionario> itens;
	private List<Funcionario> itensFiltrados;
	private String acao;
	private Long codigo;
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public List<Funcionario> getItens() {
		return itens;
	}
	public void setItens(List<Funcionario> itens) {
		this.itens = itens;
	}
	public List<Funcionario> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(List<Funcionario> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	// @PostConstruct
		public void prepararPesquisa() {
			try {
				FuncionarioDao fdao = new FuncionarioDao();
				itens = fdao.listar();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		public void carregarCadastro() {
			try {
				acao = JSFUtil.getParam("foracao");
				String valor = JSFUtil.getParam("forcad");
				
				if (valor != null) {
					codigo = Long.parseLong(valor); 
					FuncionarioDao fdao = new FuncionarioDao();
					funcionario = fdao.buscarPorCodigo(codigo);
				} else {
					funcionario = new Funcionario();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		public void salvar() {
			try {
				FuncionarioDao fdao = new FuncionarioDao();
				fdao.salvar(funcionario);
				JSFUtil.addMensagemSucesso("Fornecedor salvo com Sucesso!!!");
				funcionario = new Funcionario();
			} catch (Exception e) {
				JSFUtil.addMensagemErro("erro ao salvar: e.getMessage() " + e.getMessage());
			}
		}

		public void excluir() {
			try {
				FuncionarioDao fdao = new FuncionarioDao();
				fdao.excluir(funcionario);
				JSFUtil.addMensagemSucesso("Fornecedor deletado com Sucesso!!!");
			} catch (Exception e) {
				JSFUtil.addMensagemErro("erro ao deletar: e.getMessage() " + e.getMessage());
			}
		}

		public void editar() {
			try {
				FuncionarioDao fdao = new FuncionarioDao();
				fdao.editar1(funcionario);
				JSFUtil.addMensagemSucesso("Fornecedor editado com Sucesso!!!");
			} catch (Exception e) {
				JSFUtil.addMensagemErro("erro ao editar: e.getMessage() " + e.getMessage());
			}
		}
}
