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
import sp.senac.br.uizardy.commons.Compra;

/**
 *
 * @author blanc
 */
@Stateless
public class CompraEJB implements CompraEJBLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void cadastrar(Compra compra) {
        em.persist(compra);
    }

    @Override
    public void alterar(Compra compra) {
        Compra temp = em.find(Compra.class, compra.getIdCompra());
        if (temp != null) {
            temp = compra;
            em.merge(temp);
        }
    }

    @Override
    public List<Compra> pesquisar() {
        Query query = em.createQuery("Select Compra from Compra compra");
        List<Compra> listaCompra = (List<Compra>)query.getResultList();
        return listaCompra;
    }

    @Override
    public Compra pesquisar(int id) {
        return em.find(Compra.class, id);
    }
    
    
}
