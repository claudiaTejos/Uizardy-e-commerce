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
import sp.senac.br.beans.IdiomaEJB;
import sp.senac.br.uizardy.commons.Idioma;

/**
 *
 * @author blanc
 */

@FacesConverter
public class IdiomaConverter implements Converter{

    @EJB
    IdiomaEJB idiomaEJB;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return idiomaEJB.pesquisar(Integer.parseInt(value));
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
    
}
