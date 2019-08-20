package br.com.vendas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.vendas.DAO.FornecedoresDAO;
import br.com.vendas.doumain.Fornecedor;

@FacesConverter("fornecedoresConverter")
public class FornecedoresConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent componente, String valor) {
		try {
			Long codigo = Long.parseLong(valor);
			FornecedoresDAO fdao = new FornecedoresDAO();
			Fornecedor f = fdao.buscarPorCodigo(codigo);
			return f;
		} catch (RuntimeException e) {
			return null;
		}
		
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent componente, Object objeto) {
		try {
			Fornecedor f = (Fornecedor) objeto;
			Long codigo = f.getCodigo_for();
			return codigo.toString();
		} catch (RuntimeException e) {
			return null;
		}
		
	}

}
