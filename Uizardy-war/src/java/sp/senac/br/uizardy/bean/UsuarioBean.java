/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.uizardy.bean;

import static com.sun.xml.internal.ws.api.message.Packet.State.ClientResponse;
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
        
    public void autenticar(){
        //Validacao
        if (cpfUsuario != null) {
            try {
                funcionario = funcionarioEJB.pesquisar(cpfUsuario);
                if (funcionario.getSenhaFuncionario().equals(this.senhaUsuario)) {
                    Mensagem.mensagemInfo(Mensagem.LOGIN_SUCESSO);
                }
                else Mensagem.mensagemErro(Mensagem.LOGIN_ERRO);
            } catch (Exception e) {
                e.printStackTrace();
                Mensagem.mensagemErro(Mensagem.LOGIN_ERRO);
            }
        }
        
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    public String sair(){
        return null;
    }
    
}
