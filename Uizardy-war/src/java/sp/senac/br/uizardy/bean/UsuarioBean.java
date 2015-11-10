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
import sp.senac.br.beans.FuncionarioEJBLocal;
import sp.senac.br.uizardy.commons.Funcionario;
import sp.senac.br.uizardy.utils.Mensagem;

/**
 *
 * @author blanc
 */
@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable{

    private String cpfUsuario;
    private String senhaUsuario;
    
    Funcionario funcionario;
    
    @EJB
    private FuncionarioEJBLocal funcionarioEJB;

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public UsuarioBean() {
    }
        
    public String autenticar(){
        //Validacao
        if (cpfUsuario != null) {
            try {
                funcionario = funcionarioEJB.pesquisar(cpfUsuario);
                if (funcionario.getSenhaFuncionario().equals(this.senhaUsuario)) {
                    Mensagem.mensagemInfo(Mensagem.LOGIN_SUCESSO);
                    return "autenticado";
                }
                else Mensagem.mensagemErro(Mensagem.LOGIN_ERRO);
            } catch (Exception e) {
                e.printStackTrace();
                Mensagem.mensagemErro(Mensagem.LOGIN_ERRO);
            }
        }
        return null;
        
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    public String sair(){
        funcionario = null;
        return "nao-autenticado";
    }
   
    public void novaSenha (){
        funcionario = funcionarioEJB.pesquisar(cpfUsuario);
            if (cpfUsuario.equalsIgnoreCase(funcionario.getCpfFuncionario())) {
            Client client = Client.create();
            client.addFilter(new HTTPBasicAuthFilter("api", "key-10686595d64de24af543b2a48abe5e08"));
            WebResource webResource = client.resource("https://api.mailgun.net/v3/sandbox1a9e48fd61b54cd08d45f3648e7b1c68.mailgun.org" + "/messages");
            MultivaluedMapImpl formData = new MultivaluedMapImpl();
            formData.add("from", "Mailgun Sandbox <postmaster@sandbox1a9e48fd61b54cd08d45f3648e7b1c68.mailgun.org>");
            formData.add("to", funcionario.getEmailFuncionario());
            formData.add("subject", "Esqueci a senha");
            formData.add("text", "A sua senha é: " + funcionario.getSenhaFuncionario());
            Mensagem.mensagemInfo(Mensagem.SENHA_ENVIADA);
            webResource.type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, formData);
            return;
        }
        Mensagem.mensagemErro(Mensagem.LOGIN_ERRO);
    }
}