/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.uizardy.converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sp.senac.br.beans.FornecedorEJBLocal;
import sp.senac.br.uizardy.commons.Fornecedor;

/**
 *
 * @author blanc
 */
/*
@FacesConverter(forClass = Fornecedor.class)
public class FornecedorConverter implements Converter{

    @EJB
    FornecedorEJBLocal fornecedorEJB;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return fornecedorEJB.pesquisar(Integer.parseInt(value));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        try {
            Fornecedor fornecedor = (Fornecedor)value;
            return String.valueOf(fornecedor.getIdFornecedor());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

}*/