/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.beans;

import java.util.List;
import javax.ejb.Local;
import sp.senac.br.uizardy.commons.Produto;

/**
 *
 * @author blanc
 */
@Local
public interface ProdutoEJBLocal {
    public void cadastrar(Produto produto);
    public void alterar(Produto produto);
    public List<Produto> pesquisar();
    public Produto pesquisar (int id);
    public List<Produto> pesquisar(String busca);
}
