/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.beans;

import java.util.List;
import javax.ejb.Local;
import sp.senac.br.uizardy.commons.Carrinho;

/**
 *
 * @author blanc
 */
@Local
public interface CarrinhoEJBLocal {
    public void cadastrar(Carrinho carrinho);
    public void alterar(Carrinho carrinho);
    public List<Carrinho> pesquisar();
    public Carrinho pesquisar (int id);
}
