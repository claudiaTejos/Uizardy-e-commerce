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
    public static final String LOGIN_ERRO = "Usuario e/ou senha invalidos";
    public static final String LOGIN_SUCESSO = "Sucesso";
    public static final String EDITADO_SUCESSO = "Editado com sucesso";
    public static final String EDITADO_CANCELADO = "Edição cancelada";
    public static final String CELULA_ALTERADA = "Celula alterada";
    public static String SENHA_ENVIADA = "Senha enviada para o email cadastrado";
    
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