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
        Fornecedor temp = em.find(Fornecedor.class, fornecedor.getIdFornecedor());
        if (temp!=null) {
            temp.setRazaoSocial(fornecedor.getRazaoSocial());
            temp.setCnpj(fornecedor.getCnpj());
            temp.setEndereco(fornecedor.getEndereco());
        }
    }

    @Override
    public List<Fornecedor> pesquisar() {
        Query query = em.createQuery("Select Fornecedor from Fornecedor fornecedor");
        List<Fornecedor> fornecedor = (List<Fornecedor>)query.getResultList();
        return fornecedor;
    }    

    @Override
    public Fornecedor pesquisar(int id) {
        return em.find(Fornecedor.class, id);
    }
}