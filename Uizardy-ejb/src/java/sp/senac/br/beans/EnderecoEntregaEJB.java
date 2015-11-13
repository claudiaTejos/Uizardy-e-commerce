/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.beans;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sp.senac.br.uizardy.commons.EnderecoEntrega;
import sp.senac.br.uizardy.utils.MetodosCorreios;


/**
 *
 * @author blanc
 */
@Stateless
public class EnderecoEntregaEJB implements EnderecoEntregaEJBLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void cadastrar(EnderecoEntrega endereco) {
        em.persist(endereco);
    }

    @Override
    public void alterar(EnderecoEntrega endereco) {
        EnderecoEntrega temp = em.find(EnderecoEntrega.class, endereco.getIdEnderecoEntrega());
        if (temp != null) {
            temp = endereco;
        }
    }

    @Override
    public List<EnderecoEntrega> pesquisar() {
        Query query = em.createQuery("Select EnderecoEntrega from EnderecoEntrega enderecoEntrega");
        List<EnderecoEntrega> listaEnderecoEntrega = (List<EnderecoEntrega>)query.getResultList();
        return listaEnderecoEntrega;
    }

    @Override
    public EnderecoEntrega pesquisar(int id) {
        return em.find(EnderecoEntrega.class, id);
    }
    
    public String buscaValorEntrega(String cep){
        BigDecimal comprimento = new BigDecimal("21");
        BigDecimal altura = new BigDecimal("15");
        BigDecimal largura = new BigDecimal("5");
        BigDecimal diametro = new BigDecimal("5");
        org.tempuri.CResultado resultadoPreco = MetodosCorreios.calcPrecoPrazo(null, null, "40010", "04696000", cep, "1", 2, comprimento, altura, largura, diametro, "N", BigDecimal.ZERO, "N");
        List<org.tempuri.CServico> listaPreco = resultadoPreco.getServicos().getCServico();
        String valor = listaPreco.get(0).getValor();
        return valor;
    }
    
}
