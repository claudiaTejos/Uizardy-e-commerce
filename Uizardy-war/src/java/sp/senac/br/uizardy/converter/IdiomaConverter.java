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
import sp.senac.br.beans.IdiomaEJBLocal;
import sp.senac.br.uizardy.commons.Idioma;

/**
 *
 * @author blanc
 */
/*
@FacesConverter(forClass = Idioma.class)
public class IdiomaConverter implements Converter{

    @EJB
    IdiomaEJBLocal idiomaEJB;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int id = Integer.parseInt(value);
        try {
            return idiomaEJB.pesquisar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        try {
            Idioma idioma = (Idioma)value;
            return String.valueOf(idioma.getIdIdioma());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
    
}*/