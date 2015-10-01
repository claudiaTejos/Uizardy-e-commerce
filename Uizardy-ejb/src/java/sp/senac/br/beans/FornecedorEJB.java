/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.beans;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sp.senac.br.uizardy.commons.Fornecedor;

/**
 *
 * @author Claudio
 */
@Stateless
public class FornecedorEJB implements FornecedorEJBLocal {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void cadastrar(Fornecedor fornecedor) {
        em.persist(fornecedor);
    }

    @Override
    public void alterar(Fornecedor fornecedor) {
        em.refresh(fornecedor);
    }

    @Override
    public ArrayList<Fornecedor> pesquisar() {
        ArrayList<Fornecedor> fornecedor = new ArrayList();
        return fornecedor;
    }

    @Override
    public Fornecedor pesquisar(int id) {
        Fornecedor fornecedor = em.find(Fornecedor.class, id);
        return fornecedor;
    }
    
}
