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
import sp.senac.br.uizardy.commons.Idioma;

/**
 *
 * @author blanc
 */
@Stateless
public class IdiomaEJB implements IdiomaEJBLocal {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void cadastrar(Idioma idioma) {
        em.persist(idioma);
    }

    @Override
    public void alterar(Idioma idioma) {
        Idioma temp = em.find(Idioma.class, idioma.getIdIdioma());
        if (temp!=null) {
            temp.setNomeIdioma(idioma.getNomeIdioma());
        }
    }

    @Override
    public List<Idioma> pesquisar() {
        Query query = em.createQuery("Select Idioma from Idioma idioma");
        List<Idioma> idioma = (List<Idioma>)query.getResultList();
        return idioma;
    }

    @Override
    public Idioma pesquisar(int id) {
        return em.find(Idioma.class, id);
    }
    
}
