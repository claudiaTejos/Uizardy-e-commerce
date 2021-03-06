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
import sp.senac.br.uizardy.commons.Funcionario;

/**
 *
 * @author claudia tejos
 */
@Stateless
public class FuncionarioEJB implements FuncionarioEJBLocal {

     @PersistenceContext
    private EntityManager em;
     
    @Override
    public void cadastrar(Funcionario funcionario) {
        // salvar funcionario no banco
        em.persist(funcionario);

    }

    @Override
    public void alterar(Funcionario funcionario) {

        //encontrar o id do funcionario
        Funcionario temp = em.find(Funcionario.class, funcionario.getIdFuncionario());
        if (temp!=null) {
            //setar novos valor com os novos recebidos
            temp.setNomeFuncionario(funcionario.getNomeFuncionario());
            temp.setRgFuncionario(funcionario.getRgFuncionario());
            temp.setCpfFuncionario(funcionario.getCpfFuncionario());
            temp.setCargoFuncionario(funcionario.getCargoFuncionario());
            temp.setEnderecoFuncionario(funcionario.getEnderecoFuncionario());
            temp.setTelefoneFuncionario(funcionario.getTelefoneFuncionario());
            temp.setStatusFuncionario(funcionario.isStatusFuncionario());
            temp.setSenhaFuncionario(funcionario.getSenhaFuncionario());
            temp.setEmailFuncionario(funcionario.getEmailFuncionario());
        }
    
    }

    @Override
    public List<Funcionario> pesquisar() {
        // criacao da query par ao banco
        Query query = em.createQuery("Select Funcionario from Funcionario funcionario");
        // retorno de lista de funcionarios
        List<Funcionario> funcionario = (List<Funcionario>)query.getResultList();
        return funcionario;

    }

    @Override
    public Funcionario pesquisar(int id) {
        // pesquisa de funcionario
        return em.find(Funcionario.class, id);
    }

    @Override
    public Funcionario pesquisar(String cpf) {
        Query query = em.createQuery("Select Funcionario from Funcionario funcionario WHERE funcionario.cpfFuncionario LIKE :cpf"
                + " AND funcionario.statusFuncionario = :status");
        query.setParameter("cpf", cpf);
        query.setParameter("status", true);
        Funcionario func = (Funcionario)query.getSingleResult();
        return func;
    }

}
