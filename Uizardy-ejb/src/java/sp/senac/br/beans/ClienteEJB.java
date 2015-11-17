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
import sp.senac.br.uizardy.commons.Cliente;

/**
 *
 * @author Joana
 */
@Stateless
public class ClienteEJB implements ClienteEJBLocal {

     @PersistenceContext
    private EntityManager em;
     
    @Override
    public void cadastrar(Cliente cliente) {
        // salvar cliente no banco
        em.persist(cliente);

    }

    @Override
    public void alterar(Cliente cliente) {

        //encontrar o id do funcionario
        Cliente temp = em.find(Cliente.class, cliente.getIdCliente());
        if (temp!=null) {
            //setar novos valor com os novos recebidos
            temp.setNomeCliente(cliente.getNomeCliente());
            temp.setCpfCliente(cliente.getCpfCliente());
            temp.setEnderecoCliente(cliente.getEnderecoCliente());
            temp.setTelefoneCliente(cliente.getTelefoneCliente());
            temp.setSenhaCliente(cliente.getSenhaCliente());
            temp.setEmailCliente(cliente.getEmailCliente());
        }
    
    }

    @Override
    public List<Cliente> pesquisar() {
        // criacao da query par ao banco
        Query query = em.createQuery("Select Cliente from Cliente cliente");
        // retorno de lista de funcionarios
        List<Cliente> cliente = (List<Cliente>)query.getResultList();
        return cliente;

    }

    @Override
    public Cliente pesquisar(int id) {
        // pesquisa de funcionario
        return em.find(Cliente.class, id);
    }

    @Override
    public Cliente pesquisar(String email) {
        Query query = em.createQuery("Select Cliente from Cliente cliente WHERE cliente.emailCliente LIKE :email");
        query.setParameter("email", email);
        Cliente cli = (Cliente)query.getSingleResult();
        return cli;
    }
    
}

