/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sp.senac.br.beans.AutorEJBLocal;
import sp.senac.br.uizardy.commons.Autor;

/**
 *
 * @author blanc
 */

@FacesConverter
public class AutorConverter implements Converter{

    @EJB
    AutorEJBLocal autorEJB;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return autorEJB.pesquisar(Integer.parseInt(value));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        try {
            Autor autor = (Autor)value;
            return String.valueOf(autor.getIdAutor());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
