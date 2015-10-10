/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.beans;

import java.util.List;
import javax.ejb.Local;
import sp.senac.br.uizardy.commons.Funcionario;

/**
 *
 * @author Elisabete
 */
@Local
public interface FuncionarioEJBLocal {
    public void cadastrar(Funcionario funcionario);
    public void alterar(Funcionario funcionario);
    public List<Funcionario> pesquisar();
    public Funcionario pesquisar (int id);
    
}
