/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.beans;

import java.util.List;
import javax.ejb.Local;
import sp.senac.br.uizardy.commons.Cliente;

/**
 *
 * @author Joana
 */
@Local
public interface ClienteEJBLocal {
    public void cadastrar(Cliente cliente);
    public void alterar(Cliente cliente);
    public List<Cliente> pesquisar();
    public Cliente pesquisar (int id);
    public Cliente pesquisar (String email);
    
}
