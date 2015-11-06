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
        String login = "/backoffice/login.xhtml";
        String inicial = "/";
        
        UsuarioBean usuarioBean = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{usuarioBean}", UsuarioBean.class);
        
        //Não dar acesso à quem não estiver logado
        if (usuarioBean.getFuncionario() == null && !pagina.equals(login) && !pagina.equals(inicial)) {
            NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
            navigationHandler.handleNavigation(facesContext, null, login);
            return;
        }
        
        String acessoNegado = "/backoffice/acesso-negado.xhtml";
        String funcionario = "/backoffice/funcionario.xhtml";
        //Não dar acesso às funções de gerente para quem não for gerente
        if (usuarioBean.getFuncionario() != null && !usuarioBean.getFuncionario().getCargoFuncionario().equals("Gerente") && pagina.equals(funcionario)) {
            NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
            navigationHandler.handleNavigation(facesContext, null, acessoNegado);
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
