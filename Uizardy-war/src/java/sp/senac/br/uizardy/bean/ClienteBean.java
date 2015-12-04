/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.uizardy.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sp.senac.br.beans.ClienteEJBLocal;
import sp.senac.br.uizardy.commons.Cliente;
import sp.senac.br.uizardy.commons.EnderecoEntrega;

/**
 *
 * @author Joana
 */
@ManagedBean
@RequestScoped
public class ClienteBean {

    private Cliente cliente;

    
    @EJB
    private ClienteEJBLocal clienteEJB;
    /**
     * Creates a new instance of FuncionarioBean
     */
    public ClienteBean() {
        this.cliente = new Cliente();
        EnderecoEntrega end = new EnderecoEntrega();
        this.cliente.setEnderecoCliente(end);
        
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    // cadostro de funcionario
    public void cadastrarCliente(){
        clienteEJB.cadastrar(this.cliente);
        this.cliente = null;
    }
    
    // pesquisa de funcionario cadastrados no banco (todos)
    public List<Cliente> pesquisarListaClientes(){
        return clienteEJB.pesquisar();
    }
    
    // pesquisa de funcionario especifico
    public Cliente pesquisarCliente (int id){
        return clienteEJB.pesquisar(id);
    }
    
    //autalizacao de dados de funcionario
    public void atualizarCliente(){
        clienteEJB.alterar(this.cliente);
    }
    
}
