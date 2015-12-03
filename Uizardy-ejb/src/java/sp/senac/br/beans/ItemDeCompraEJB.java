/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sp.senac.br.uizardy.commons.ItemDeCompra;

/**
 *
 * @author blanc
 */
@Stateless
public class ItemDeCompraEJB implements ItemDeCompraEJBLocal {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void cadastrar(ItemDeCompra item) {
        em.persist(item);
    }

    @Override
    public void alterar(ItemDeCompra item) {
        ItemDeCompra itemCompra = this.pesquisar(item.getIdItem());
        itemCompra = item;
    }

    @Override
    public List<ItemDeCompra> pesquisar() {
        Query query = em.createQuery("Select ItemDeCompra from ItemDeCompra itemDeCompra");
        List<ItemDeCompra> itens = (List<ItemDeCompra>)query.getResultList();
        return itens;
    }

    @Override
    public ItemDeCompra pesquisar(int id) {
        return em.find(ItemDeCompra.class, id);
    }

}
