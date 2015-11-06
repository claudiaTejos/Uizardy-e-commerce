/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.uizardy.view;
 
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import sp.senac.br.beans.IdiomaEJBLocal;
import sp.senac.br.uizardy.commons.Idioma;
import sp.senac.br.uizardy.utils.Mensagem;
 
/**
 *
 * @author blanc
 */

@ManagedBean(name="dtEditView")
@ViewScoped
public class dtEditView implements Serializable {
    
    @EJB
    private IdiomaEJBLocal idiomaEJB;
    
    @PostConstruct
    public void init() {
        
    }
    
    public void setIdioma(Idioma idioma){
        idiomaEJB.alterar(idioma);
    }
    
    public List<Idioma> listaIdioma(){
        return idiomaEJB.pesquisar();
    }
     
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage(Mensagem.EDITADO_SUCESSO, ((Idioma) event.getObject()).getNomeIdioma());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage(Mensagem.EDITADO_CANCELADO, ((Idioma) event.getObject()).getNomeIdioma());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        
        Idioma idiomaAlterado = (Idioma) newValue;
        idiomaEJB.alterar(idiomaAlterado);
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, Mensagem.CELULA_ALTERADA, "Antigo: " + oldValue + ", Novo:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}