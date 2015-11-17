/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.uizardy.bean;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.core.MediaType;
import sp.senac.br.beans.ClienteEJBLocal;
import sp.senac.br.uizardy.commons.Cliente;
import sp.senac.br.uizardy.utils.Mensagem;

/**
 *
 * @author Joana
 */
@ManagedBean
@SessionScoped
public class UsuarioClienteBean implements Serializable{

    private String emailUsuarioCliente;
    private String senhaUsuarioCliente;
    
    Cliente cliente;
    
    @EJB
    private ClienteEJBLocal clienteEJB;

    public String getEmailUsuarioCliente() {
        return emailUsuarioCliente;
    }

    public void setEmailUsuarioCliente(String emailUsuarioCliente) {
        this.emailUsuarioCliente = emailUsuarioCliente;
    }

    public String getSenhaUsuarioCliente() {
        return senhaUsuarioCliente;
    }

    public void setSenhaUsuarioCliente(String senhaUsuarioCliente) {
        this.senhaUsuarioCliente = senhaUsuarioCliente;
    }

    public UsuarioClienteBean() {
    }
        
    public String autenticar(){
        //Validacao
        if (emailUsuarioCliente != null) {
            try {
                cliente = clienteEJB.pesquisar(emailUsuarioCliente);
                if (cliente.getSenhaCliente().equals(this.senhaUsuarioCliente)) {
                    Mensagem.mensagemInfo(Mensagem.LOGIN_SUCESSO);
                    return "autenticadoCliente";
                }
                else Mensagem.mensagemErro(Mensagem.LOGIN_ERRO);
            } catch (Exception e) {
                e.printStackTrace();
                Mensagem.mensagemErro(Mensagem.LOGIN_ERRO);
            }
        }
        return null;
        
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public String sair(){
        cliente = null;
        return "nao-autenticadoCliente";
    }
   
    public void novaSenha (){
        cliente = clienteEJB.pesquisar(emailUsuarioCliente);
            if (emailUsuarioCliente.equalsIgnoreCase(cliente.getEmailCliente())) {
            Client client = Client.create();
            client.addFilter(new HTTPBasicAuthFilter("api", "key-10686595d64de24af543b2a48abe5e08"));
            WebResource webResource = client.resource("https://api.mailgun.net/v3/sandbox1a9e48fd61b54cd08d45f3648e7b1c68.mailgun.org" + "/messages");
            MultivaluedMapImpl formData = new MultivaluedMapImpl();
            formData.add("from", "Mailgun Sandbox <postmaster@sandbox1a9e48fd61b54cd08d45f3648e7b1c68.mailgun.org>");
            formData.add("to", cliente.getEmailCliente());
            formData.add("subject", "Esqueci a senha");
            formData.add("text", "A sua senha é: " + cliente.getSenhaCliente());
            Mensagem.mensagemInfo(Mensagem.SENHA_ENVIADA);
            webResource.type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, formData);
            return;
        }
        Mensagem.mensagemErro(Mensagem.LOGIN_ERRO);
    }
}