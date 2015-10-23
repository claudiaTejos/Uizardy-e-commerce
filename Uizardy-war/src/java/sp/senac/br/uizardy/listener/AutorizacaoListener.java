/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.uizardy.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import sp.senac.br.uizardy.bean.UsuarioBean;

/**
 *
 * @author blanc
 */
public class AutorizacaoListener implements PhaseListener{

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        
        String pagina = facesContext.getViewRoot().getViewId();
        UsuarioBean usuarioBean = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{usuarioBean}", UsuarioBean.class);
        
        if (pagina.contains("produto.xhtml") && usuarioBean.getFuncionario() == null) {
            NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
            navigationHandler.handleNavigation(facesContext, null, pagina);
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
}
