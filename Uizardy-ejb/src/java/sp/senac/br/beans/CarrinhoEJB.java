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
import sp.senac.br.uizardy.commons.Carrinho;

/**
 *
 * @author blanc
 */
@Stateless
public class CarrinhoEJB implements CarrinhoEJBLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void cadastrar(Carrinho carrinho) {
        em.persist(carrinho);
    }

    @Override
    public void alterar(Carrinho carrinho) {
        Carrinho temp = em.find(Carrinho.class, carrinho.getIdCarrinho());
        if (temp != null) {
            temp = carrinho;
            em.merge(temp);
        }
    }

    @Override
    public List<Carrinho> pesquisar() {
        Query query = em.createQuery("Select Carrinho from Carrinho carrinho");
        List<Carrinho> listaCarrinho = (List<Carrinho>)query.getResultList();
        return listaCarrinho;
    }

    @Override
    public Carrinho pesquisar(int id) {
        return em.find(Carrinho.class, id);
    }
    
    
}
