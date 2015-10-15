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
import sp.senac.br.uizardy.commons.Autor;

/**
 *
 * @author blanco
 */
@Stateless
public class AutorEJB implements AutorEJBLocal {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void cadastrar(Autor autor) {
        em.persist(autor);
    }

    @Override
    public void alterar(Autor autor) {
        Autor temp = em.find(Autor.class, autor.getIdAutor());
        if (temp!=null) {
            temp.setNomeAutor(autor.getNomeAutor());
            temp.setProdutos(autor.getProdutos());
        }
    }

    @Override
    public List<Autor> pesquisar() {
        Query query = em.createQuery("Select Autor from Autor autor");
        List<Autor> autor = (List<Autor>)query.getResultList();
        return autor;
    }

    @Override
    public Autor pesquisar(int id) {
        return em.find(Autor.class, id);
    }
}
