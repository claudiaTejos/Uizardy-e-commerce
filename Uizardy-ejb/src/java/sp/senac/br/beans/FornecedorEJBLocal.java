/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.beans;

import java.util.ArrayList;
import javax.ejb.Local;
import sp.senac.br.uizardy.commons.Fornecedor;

/**
 *
 * @author Claudio
 */
@Local
public interface FornecedorEJBLocal {
    public void cadastrar(Fornecedor fornecedor);
    public void alterar(Fornecedor fornecedor);
    public ArrayList<Fornecedor> pesquisar();
    public Fornecedor pesquisar(int id);
}
