/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.beans;

import java.util.List;
import javax.ejb.Local;
import sp.senac.br.uizardy.commons.ItemDeCompra;

/**
 *
 * @author blanc
 */
@Local
public interface ItemDeCompraEJBLocal {
    public void cadastrar(ItemDeCompra item);
    public void alterar(ItemDeCompra item);
    public List<ItemDeCompra> pesquisar();
    public ItemDeCompra pesquisar (int id);
}
