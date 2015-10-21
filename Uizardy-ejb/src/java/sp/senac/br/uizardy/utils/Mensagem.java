/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.uizardy.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author blanc
 */
public class Mensagem {
    public static final String INCLUIDO_SUCESSO = "Incluido com sucesso!";
    public static final String ALTERADO_SUCESSO = "Alterado com sucesso!";
    
    public static void mensagemInfo (String msg){
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }
    
    public static void mensagemErro (String msg){
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }
    
    public static void mensagemAviso (String msg){
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }
    
    public static void mensagemFatal (String msg){
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }
}
