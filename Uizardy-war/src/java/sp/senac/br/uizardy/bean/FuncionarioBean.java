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
import sp.senac.br.beans.FuncionarioEJBLocal;
import sp.senac.br.uizardy.commons.Funcionario;

/**
 *
 * @author Elisabete
 */
@ManagedBean
@RequestScoped
public class FuncionarioBean {

    private Funcionario funcionario;

    
    @EJB
    private FuncionarioEJBLocal funcionarioEJB;
    /**
     * Creates a new instance of FuncionarioBean
     */
    public FuncionarioBean() {
        this.funcionario = new Funcionario();
        
    }
    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    // cadostro de funcionario
    public void cadastrarFuncionario(){
        funcionarioEJB.cadastrar(this.funcionario);
        this.funcionario = null;
    }
    
    // pesquisa de funcionario cadastrados no banco (todos)
    public List<Funcionario> pesquisarListaFuncionarios(){
        return funcionarioEJB.pesquisar();
    }
    
    // pesquisa de funcionario especifico
    public Funcionario pesquisarFuncionario (int id){
        return funcionarioEJB.pesquisar(id);
    }
    
    //autalizacao de dados de funcionario
    public void atualizarFuncionario(){
        funcionarioEJB.alterar(this.funcionario);
    }
    
}
